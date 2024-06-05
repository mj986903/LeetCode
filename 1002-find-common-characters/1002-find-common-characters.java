class Solution {
    public List<String> commonChars(String[] words) {
        int [] minFreq = new int[26];
        for(int i=0;i<words[0].length();i++){
            minFreq[words[0].charAt(i) - 'a']++;
        }
        
        for(int i=1;i<words.length;i++){
            int [] freq = new int [26];
            for(int j=0;j<words[i].length();j++){
                freq[words[i].charAt(j) - 'a']++;
            }
            for(int j=0;j<26;j++){
                minFreq[j] = Math.min(minFreq[j],freq[j]);
            }
        }
        
        List<String> ans = new ArrayList<>();
        for(int i=0;i<26;i++){
            while(minFreq[i] > 0){
                ans.add(String.valueOf((char)(i+'a')));
                minFreq[i]--;
            }
        }
        return ans;
    }
}