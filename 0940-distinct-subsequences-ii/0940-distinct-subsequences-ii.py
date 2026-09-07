class Solution:
    def distinctSubseqII(self, s: str) -> int:
        dp = 0
        freq = [0] * 26

        MOD = 10**9 + 7

        for ch in s :

            new_dp = (2 * dp + 1 - freq[ord(ch) - ord('a')]) % MOD

            if new_dp < 0:
                new_dp += MOD

            freq[ord(ch) - ord('a')] = dp + 1
            dp = new_dp

        return dp