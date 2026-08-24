class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        freq = [0] * 128

        lft = 0
        mx = 0

        for rght in range(len(s)):
            ch = s[rght]
            freq[ord(ch)] += 1

            while freq[ord(ch)] > 1:
                freq[ord(s[lft])] -= 1
                lft += 1

            mx = max(mx , rght - lft + 1)

        return mx