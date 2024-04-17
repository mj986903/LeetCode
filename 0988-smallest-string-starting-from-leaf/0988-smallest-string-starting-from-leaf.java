class Solution {
    private void helper(TreeNode root,StringBuilder path,StringBuilder smallest) {
        if (root == null){
            return;
        }
        path.append((char)('a' + root.val));
        if (root.left == null && root.right == null) {
            String currentString = path.reverse().toString();
            if (smallest.length() == 0 || currentString.compareTo(smallest.toString()) < 0) {
                smallest.setLength(0);
                smallest.append(currentString);
            }
            path.reverse();
        }
        helper(root.left, path, smallest);
        helper(root.right, path, smallest);
        path.deleteCharAt(path.length()-1);
    }
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder smallest = new StringBuilder();
        helper(root, new StringBuilder(), smallest);
        return smallest.toString();
    }
}