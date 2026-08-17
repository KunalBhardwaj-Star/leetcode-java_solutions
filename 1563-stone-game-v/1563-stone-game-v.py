from typing import List


class Solution:
    def stoneGameV(self, stoneValue: List[int]) -> int:
        n = len(stoneValue)

        prefix = [0] * (n + 1)

        for i in range(n):
            prefix[i + 1] = prefix[i] + stoneValue[i]

        dp = [[0] * n for _ in range(n)]

        left_best = [[0] * n for _ in range(n)]

        right_best = [[0] * n for _ in range(n)]

        for i in range(n):
            left_best[i][i] = prefix[i + 1]
            right_best[i][i] = -prefix[i]

        for length in range(2, n + 1):

            for l in range(n - length + 1):
                r = l + length - 1

                total = prefix[r + 1] - prefix[l]

                lo = l
                hi = r - 1

                while lo <= hi:
                    mid = (lo + hi) // 2

                    left_sum = prefix[mid + 1] - prefix[l]
                    right_sum = total - left_sum

                    if left_sum <= right_sum:
                        lo = mid + 1
                    else:
                        hi = mid - 1

                if hi >= l:
                    dp[l][r] = max(
                        dp[l][r],
                        left_best[l][hi] - prefix[l]
                    )

                if hi >= l:
                    equality_left = prefix[hi + 1] - prefix[l]
                    equality_right = total - equality_left

                    if equality_left == equality_right:
                        start = hi
                    else:
                        start = lo
                else:
                    start = lo

                if start <= r - 1:
                    dp[l][r] = max(
                        dp[l][r],
                        prefix[r + 1] + right_best[start + 1][r]
                    )

                left_best[l][r] = max(
                    left_best[l][r - 1],
                    prefix[r + 1] + dp[l][r]
                )

                right_best[l][r] = max(
                    right_best[l + 1][r],
                    dp[l][r] - prefix[l]
                )

        return dp[0][n - 1]