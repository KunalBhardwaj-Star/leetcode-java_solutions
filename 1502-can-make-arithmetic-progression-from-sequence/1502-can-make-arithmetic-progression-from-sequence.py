class Solution:
    def canMakeArithmeticProgression(self, arr: List[int]) -> bool:
        arr.sort()
        diff = arr[1] - arr[0]

        for i in range(2 , len(arr)):
            curr = arr[i] - arr[i-1]

            if curr != diff :
                return False

        return True