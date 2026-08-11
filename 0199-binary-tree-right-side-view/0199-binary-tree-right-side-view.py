# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root == None:
            return []

        q = deque()

        q.append(root)

        ans = []

        while q :
            size = len(q)

            for i in range(0 , size):
                curr = q.popleft()

                if curr.left != None:
                    q.append(curr.left)

                if curr.right != None:
                    q.append(curr.right)

                if i == size - 1:
                    ans.append(curr.val)

        return ans