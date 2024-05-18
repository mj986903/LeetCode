/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int ans=0;
    public int distributeCoins(TreeNode root) {
        countSteps(root);
        return ans;
    }
    public int countSteps(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftCoins = countSteps(root.left);
        int rightCoins = countSteps(root.right);
        ans = ans + Math.abs(leftCoins) + Math.abs(rightCoins);
        return (root.val - 1) + leftCoins + rightCoins;
    }
}