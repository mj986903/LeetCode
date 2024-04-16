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
    private static TreeNode add(TreeNode root, int val, int depth, int curr){
        if(root == null){
            return null;
        }
        if(curr == depth-1){
            TreeNode temp = root.left;
            root.left = new TreeNode(val);
            root.left.left = temp;
            
            temp = root.right;
            root.right = new TreeNode(val);
            root.right.right = temp;
            
            return root;
        }
        root.left = add(root.left,val,depth,curr+1);
        root.right = add(root.right,val,depth,curr+1);
        return root;
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            root = newNode;
            return root;
        }
        return add(root,val,depth,1);
    }
}