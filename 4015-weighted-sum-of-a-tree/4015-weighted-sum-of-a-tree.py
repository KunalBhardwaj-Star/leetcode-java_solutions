class Solution:

    def __init__(self):
        self.depth = []
        self.max_hght = 0

    def getDepth(self , parent: list[int] , node: int) -> int:
        if parent[node] == -1:
            return 1

        if self.depth[node] != -1:
            return self.depth[node]

        self.depth[node] = self.getDepth(parent , parent[node]) + 1

        return self.depth[node]


    def weightedSum(self, parent: list[int], nums: list[int]) -> int:
        self.depth = [-1] * len(parent)

        for i in range(0 , len(nums)):
            self.depth[i] = self.getDepth(parent , i)
            self.max_hght = max(self.max_hght , self.depth[i])

        ans = 0

        for i in range(0 , len(nums)):
            curr = self.max_hght - self.depth[i] + 1
            ans += (nums[i] * curr)

        return ans
        

