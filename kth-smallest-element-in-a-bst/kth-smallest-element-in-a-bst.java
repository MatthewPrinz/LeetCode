/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> nodes = new ArrayList<>();
        traverse(root, nodes);
        Collections.sort(nodes);
        return nodes.get(k-1);
        
    }
    
    public void traverse(TreeNode root, List<Integer> nodes)
    {
        if (root == null)
            return;
        traverse(root.left, nodes);
        nodes.add(root.val);
        traverse(root.right, nodes);
    }
}
