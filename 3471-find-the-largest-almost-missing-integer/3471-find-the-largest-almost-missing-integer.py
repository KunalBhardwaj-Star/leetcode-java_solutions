class Solution:
    def largestInteger(self, nums: List[int], k: int) -> int:
        n = len(nums)

        mp = {}

        for i in range(0 , n - k + 1):

            seen = set()

            for j in range(i , i + k):
                seen.add(nums[j])

            for x in seen :
                mp[x] = mp.get(x , 0) + 1

        mx = -1

        for ele in mp :
            if mp[ele] == 1 :
                mx = max(mx , ele)

        return mx



