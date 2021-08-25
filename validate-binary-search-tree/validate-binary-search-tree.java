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
        Set<Boolean> result = new HashSet<>();
        helper(root, Long.MIN_VALUE, Long.MAX_VALUE, result);
        return !result.contains(false);
    }
    
    public boolean helper(TreeNode root, Long min, Long max, Set<Boolean> set) {
        if (root == null) {
            set.add(true);
            return true;
        }
        else if (root.val <= min || root.val >= max) {
            set.add(false);
            return false;
        }
        else 
            return helper(root.left, new Long(min), new Long(root.val), set) && helper(root.right, new Long(root.val), new Long(max), set);
        
    }
}