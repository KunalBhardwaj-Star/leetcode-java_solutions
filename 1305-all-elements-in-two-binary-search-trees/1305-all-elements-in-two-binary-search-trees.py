# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def traverseTree(self , root : Optional[TreeNode] , ans):
        if root == None:
            return 

        ans.append(root.val)
        self.traverseTree(root.left , ans)
        self.traverseTree(root.right , ans)

    def getAllElements(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> List[int]:
        ans = []

        self.traverseTree(root1 , ans)
        self.traverseTree(root2 , ans)

        ans.sort()
        return ans
