import os
import json
import time
import base64
import requests

# --- Config ---
LEETCODE_USER = os.environ.get("LEETCODE_USER")
LEETCODE_SESSION = os.environ.get("LEETCODE_SESSION")
GITHUB_TOKEN = os.environ.get("GITHUB_TOKEN")
GITHUB_REPO = os.environ.get("GITHUB_REPO")
GITHUB_BRANCH = os.environ.get("GITHUB_BRANCH", "main")
MAX_FETCH = int(os.environ.get("MAX_FETCH", "100"))

if not all([LEETCODE_USER, LEETCODE_SESSION, GITHUB_TOKEN, GITHUB_REPO]):
    raise SystemExit("Set LEETCODE_USER, LEETCODE_SESSION, GITHUB_TOKEN, GITHUB_REPO")

# --- Endpoints ---
LC_GRAPHQL = "https://leetcode.com/graphql"
SESSION = requests.Session()
SESSION.headers.update({
    "Content-Type": "application/json",
    "User-Agent": "Mozilla/5.0 (LeetCodeSync/1.0)",
    "Referer": "https://leetcode.com",
})
SESSION.cookies.update({"LEETCODE_SESSION": LEETCODE_SESSION})

GITHUB_HEADERS = {
    "Authorization": f"Bearer {GITHUB_TOKEN}",
    "Accept": "application/vnd.github.v3+json",
    "User-Agent": "LeetCodeSyncScript"
}

# --- GraphQL queries ---
RECENT_AC_QUERY = """
query recentAcSubmissionList($userSlug: String!, $limit: Int!) {
  recentAcSubmissionList(username: $userSlug, limit: $limit) {
    id
    title
    titleSlug
    lang
    timestamp
    __typename
  }
}
"""

SUBMISSION_DETAIL_QUERY = """
query submissionDetail($id: Int!) {
  submissionDetail(submissionId: $id) {
    id
    code
    lang
    question {
      title
      titleSlug
      questionId
    }
  }
}
"""

# --- Helpers ---
LANG_EXT_MAP = {
    "cpp": "cpp", "cpp14": "cpp", "cpp11": "cpp",
    "python": "py", "python3": "py",
    "java": "java", "c": "c", "csharp": "cs",
    "golang": "go", "javascript": "js", "typescript": "ts",
    "ruby": "rb", "php": "php", "swift": "swift", "kotlin": "kt",
}

def lang_to_ext(lang: str) -> str:
    return LANG_EXT_MAP.get(lang.lower(), "txt")

def sanitize_filename(s: str) -> str:
    return "".join(c if c.isalnum() or c in "._-" else "_" for c in s).strip()

def graphql_post(query, variables):
    r = SESSION.post(LC_GRAPHQL, json={"query": query, "variables": variables}, timeout=30)
    r.raise_for_status()
    data = r.json()
    if "errors" in data:
        raise RuntimeError(data["errors"])
    return data.get("data", {})

def github_get_file(path: str):
    url = f"https://api.github.com/repos/{GITHUB_REPO}/contents/{path}"
    resp = requests.get(url, headers=GITHUB_HEADERS, params={"ref": GITHUB_BRANCH})
    if resp.status_code == 200:
        return resp.json()
    elif resp.status_code == 404:
        return None
    else:
        resp.raise_for_status()

def github_put_file(path: str, content_bytes: bytes, message: str, sha: str = None):
    url = f"https://api.github.com/repos/{GITHUB_REPO}/contents/{path}"
    b64 = base64.b64encode(content_bytes).decode("utf-8")
    payload = {"message": message, "content": b64, "branch": GITHUB_BRANCH}
    if sha:
        payload["sha"] = sha
    resp = requests.put(url, headers=GITHUB_HEADERS, json=payload, timeout=30)
    resp.raise_for_status()
    return resp.json()

# Tracking synced submissions
TRACKING_FILE = ".leetcode_synced.json"

def load_tracking():
    remote = github_get_file(TRACKING_FILE)
    if remote:
        content = base64.b64decode(remote["content"])
        return json.loads(content.decode())
    return {"synced_submission_ids": []}

def save_tracking(tracking):
    content_bytes = json.dumps(tracking, indent=2).encode("utf-8")
    existing = github_get_file(TRACKING_FILE)
    sha = existing["sha"] if existing else None
    github_put_file(TRACKING_FILE, content_bytes, "chore: update LeetCode sync tracking", sha=sha)

# --- Main sync ---
def main():
    print(f"Fetching up to {MAX_FETCH} recent accepted submissions for {LEETCODE_USER}...")
    recent = graphql_post(RECENT_AC_QUERY, {"userSlug": LEETCODE_USER, "limit": MAX_FETCH})["recentAcSubmissionList"]
    tracking = load_tracking()
    synced_ids = set(tracking.get("synced_submission_ids", []))

    new_submissions = [s for s in recent if int(s["id"]) not in synced_ids]
    print(f"{len(new_submissions)} new submissions to sync.")

    for sub in sorted(new_submissions, key=lambda x: int(x["timestamp"])):
        sid = int(sub["id"])
        detail = graphql_post(SUBMISSION_DETAIL_QUERY, {"id": sid})["submissionDetail"]
        code = detail["code"]
        lang = detail["lang"]
        q = detail["question"]
        title_slug = q["titleSlug"]
        question_id = int(q["questionId"])
        ext = lang_to_ext(lang)
        
        folder = f"{question_id:04d}-{title_slug}"
        file_name = f"{question_id:04d}-{title_slug}.{ext}"
        repo_path = f"{folder}/{file_name}"
        commit_msg = f"chore: add {folder} solution ({sid}) [{lang}]"

        existing = github_get_file(repo_path)
        sha = existing["sha"] if existing else None

        github_put_file(repo_path, code.encode("utf-8"), commit_msg, sha=sha)
        print(f"Uploaded {repo_path}")
        synced_ids.add(sid)
        time.sleep(1)  # avoid rate limits

    tracking["synced_submission_ids"] = sorted(list(synced_ids))
    save_tracking(tracking)
    print("Sync complete.")

if __name__ == "__main__":
    main()
