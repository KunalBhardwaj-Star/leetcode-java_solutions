class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        
        ans = [[0] * n for _ in range(m)]

        for x in range(0 , m):
            temp = [0] * n
            for y in range(0 , n):
                if x == 0 or y == 0 :
                    temp[y] = 1

                else :
                    temp[y] = ans[x - 1][y] + temp[y - 1]

            ans[x] = temp[:]

        return ans[m-1][n-1]