
import java.util.*;

class Solution {
    public int minimumChanges(String s, int k) {

        int n = s.length();
        int INF = 1000000;

        int[][] cost = new int[n][n];

        for (int[] row : cost) {
            Arrays.fill(row, INF);
        }

        for (int len = 2; len <= n; len++) {

            for (int l = 0; l + len <= n; l++) {

                int r = l + len - 1;

                for (int d = 1; d < len; d++) {

                    if (len % d != 0) {
                        continue;
                    }

                    int changes = 0;

                    for (int rem = 0; rem < d; rem++) {

                        int count = (len - 1 - rem) / d + 1;

                        for (int t = 0; t < count / 2; t++) {

                            int left = l + rem + t * d;

                            int right = l + rem
                                      + (count - 1 - t) * d;

                            if (s.charAt(left) != s.charAt(right)) {
                                changes++;
                            }
                        }
                    }

                    cost[l][r] = Math.min(cost[l][r], changes);
                }
            }
        }

        int[][] dp = new int[k + 1][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        dp[0][0] = 0;

        for (int p = 1; p <= k; p++) {

            for (int i = 2 * p; i <= n - 2 * (k - p); i++) {

                for (int j = 2 * (p - 1); j <= i - 2; j++) {

                    if (dp[p - 1][j] == INF) {
                        continue;
                    }

                    dp[p][i] = Math.min(
                        dp[p][i],
                        dp[p - 1][j] + cost[j][i - 1]
                    );
                }
            }
        }

        return dp[k][n];
    }
}
