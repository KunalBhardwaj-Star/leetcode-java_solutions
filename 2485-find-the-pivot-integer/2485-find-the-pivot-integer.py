class Solution:
    def pivotInteger(self, n: int) -> int:
        rght = [0] * n
        lft = [0] * n

        lft[0] = 1
        rght[n - 1] = n 

        for i in range(1 , n):
            lft[i] = lft[i-1] + i + 1
            
        for i in range(n-2 , -1 , -1):
            rght[i] = rght[i+1] + i + 1

        for x in range(0 , n):
            if lft[x] == rght[x] :
                return x + 1

        return -1