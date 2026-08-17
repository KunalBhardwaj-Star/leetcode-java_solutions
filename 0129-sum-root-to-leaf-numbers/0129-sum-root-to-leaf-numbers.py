# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def dfs(self , root: Optional[TreeNode] , curr) -> None:
        if root is None :
            return
        
        curr = curr * 10 + root.val

        if root.left is None and root.right is None :
            self.ans += curr
            return

        self.dfs(root.left , curr) 
        self.dfs(root.right , curr)
    
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.ans = 0

        self.dfs(root , 0)

        return self.ans