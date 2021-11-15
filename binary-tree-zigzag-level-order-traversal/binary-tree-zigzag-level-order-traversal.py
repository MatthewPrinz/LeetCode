# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        queue = deque()
        result = []
        if root is None:
            return result
        queue.append(root)
        i = 0
        while queue:
            size = len(queue)
            level = []
            for _ in range(size):
                node = queue.popleft()
                if node.left is not None:
                    queue.append(node.left)
                if node.right is not None:
                    queue.append(node.right)
                level.append(node.val)
            if i % 2 == 1:
                level.reverse()
            i += 1
            result.append(level)
        return result
            
        