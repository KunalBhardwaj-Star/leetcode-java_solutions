class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;

        // dp[i][j][k] = max money at (i,j) using k skips
        int[][][] dp = new int[m][n][3];

        // Initialize with very small value
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }

        // Base case (0,0)
        dp[0][0][0] = coins[0][0];

        // If starting cell is negative, we can skip it
        if (coins[0][0] < 0) {
            dp[0][0][1] = 0;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                for (int k = 0; k < 3; k++) {

                    if (dp[i][j][k] == Integer.MIN_VALUE) continue;

                    // Move RIGHT
                    if (j + 1 < n) {
                        int val = coins[i][j + 1];

                        // Take value
                        dp[i][j + 1][k] = Math.max(
                            dp[i][j + 1][k],
                            dp[i][j][k] + val
                        );

                        // Skip if negative
                        if (val < 0 && k < 2) {
                            dp[i][j + 1][k + 1] = Math.max(
                                dp[i][j + 1][k + 1],
                                dp[i][j][k]
                            );
                        }
                    }

                    // Move DOWN
                    if (i + 1 < m) {
                        int val = coins[i + 1][j];

                        // Take value
                        dp[i + 1][j][k] = Math.max(
                            dp[i + 1][j][k],
                            dp[i][j][k] + val
                        );

                        // Skip if negative
                        if (val < 0 && k < 2) {
                            dp[i + 1][j][k + 1] = Math.max(
                                dp[i + 1][j][k + 1],
                                dp[i][j][k]
                            );
                        }
                    }
                }
            }
        }

        // Final answer = max of all skip states
        return Math.max(dp[m - 1][n - 1][0],
               Math.max(dp[m - 1][n - 1][1], dp[m - 1][n - 1][2]));
    }
}