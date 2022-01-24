The following reduces the number of parameters in the helper in exchange for using a member variable.
```
class Solution {
private int preIndex = 0;
public TreeNode buildTree(int[] preorder, int[] inorder) {
Map<Integer, Integer> valuesToIndex = new HashMap<>();
for (int i = 0; i < inorder.length; i++) {
valuesToIndex.put(inorder[i], i);
}
return helper(preorder, inorder, 0, inorder.length - 1, valuesToIndex);
}
TreeNode helper(int[] preorder, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> valuesToIndex) {
if (inStart > inEnd) {
return null;
}
TreeNode root = new TreeNode(preorder[preIndex++]);
if (inStart == inEnd) {
return root;
}
int inIndex = valuesToIndex.get(root.val);
root.left = helper(preorder, inorder, inStart, inIndex - 1, valuesToIndex);
root.right = helper(preorder, inorder, inIndex + 1, inEnd, valuesToIndex);
return root;
}
}
```
Similarly, the submitted solution could have reduced parameters in the helper if one were to make ```valuesToIndex``` a private member variable.
​