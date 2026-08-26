class Solution:
    def shortestBeautifulSubstring(self, s: str, k: int) -> str:
        n = len(s)

        ones = 0
        lft = 0

        ans = ""

        for rght in range(0 , n):
            if s[rght] == '1':
                ones += 1

            while ones > k :
                if s[lft] == '1':
                    ones -= 1

                lft += 1

            if ones == k:
                while s[lft] == '0':
                    lft += 1

                curr = s[lft : rght + 1]

                if len(ans) > len(curr) or ans == "" or (ans > curr and len(ans) == len(curr)):
                    ans = curr

        return ans

                