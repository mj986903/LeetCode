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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        boolean flag = true;
        q.add(root);
        while(!q.isEmpty()){
            int level = q.size();
            int prev;
            if(flag){
                prev = Integer.MIN_VALUE;
            }else{
                prev = Integer.MAX_VALUE;
            }
            for(int i=0;i<level;i++){
                TreeNode temp = q.poll();
                if(flag && (temp.val % 2 == 0 || temp.val <= prev)){
                    return false;
                }
                if(!flag && (temp.val % 2 != 0 || temp.val >= prev)){
                    return false;
                }
                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
                   prev = temp.val;
            }
            flag = !flag;
        }
        return true;
    }
}