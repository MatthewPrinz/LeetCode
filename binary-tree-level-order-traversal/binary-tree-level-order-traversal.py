# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result = []
        queue = deque()
        if root is None:
            return result
        queue.append(root)
        while len(queue) > 0:
            level = []
            size = len(queue)
            for i in range(size):
                node = queue.popleft()
                if node.left is not None:
                    queue.append(node.left)
                if node.right is not None:
                    queue.append(node.right)
                level.append(node.val)
            result.append(level)
        return result
        
            
                    
        
        