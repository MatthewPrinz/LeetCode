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
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    boolean helper(TreeNode root, Long min, Long max) {
        if (root == null)
            return true;
        else if (root.val <= min || root.val >= max) {
            return false;
        } else {
            return helper(root.left, new Long(min), new Long(root.val)) && helper(root.right, new Long(root.val), new Long(max));
        }
    }
}