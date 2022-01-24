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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> valuesToIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valuesToIndex.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, valuesToIndex);
    }
    TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> valuesToIndex) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = valuesToIndex.get(root.val);
        int numsOnLeft = rootIndex - inStart;
        root.left = helper(preorder, preStart + 1, preStart + numsOnLeft, inorder, inStart, rootIndex - 1, valuesToIndex);
        root.right = helper(preorder, preStart + numsOnLeft + 1, preEnd, inorder, inStart + numsOnLeft + 1, inEnd, valuesToIndex);
        return root;
    }
}
