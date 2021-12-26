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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } 
        if (root.left == null && root.right == null) {
            return true;
        }
        return Math.abs(findHeight(root.left) - findHeight(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        
    }
    
    int findHeight(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(findHeight(root.left), findHeight(root.right));
    }
}