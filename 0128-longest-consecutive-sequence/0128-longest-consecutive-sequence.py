class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        s = set()

        ans = 0

        for num in nums :
            s.add(num)

        for x in s :
            if (x - 1) not in s:
                curr = x
                len = 1

                while (curr + 1) in s:
                    len += 1
                    curr += 1

                ans = max(ans , len)

        return ans

