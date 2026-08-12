class Solution:
    def maxSubarrayLength(self, nums: List[int], k: int) -> int:
        freq = {}

        n = len(nums)

        l = 0

        maxSize = 0

        for r in range(0 , n):
            freq[nums[r]] = freq.get(nums[r] , 0) + 1

            while freq.get(nums[r]) > k:
                freq[nums[l]] = freq.get(nums[l] , 0) - 1;

                if freq[nums[l]] == 0:
                    del freq[nums[l]]

                l += 1

            maxSize = max(maxSize , r - l + 1)

        return maxSize
        