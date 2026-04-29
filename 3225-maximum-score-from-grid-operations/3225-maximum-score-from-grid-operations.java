class Solution {
    public long maximumScore(int[][] grid) {
        int n = grid.length;
        
        long[][] pref = new long[n][n + 1];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                pref[j][i + 1] = pref[j][i] + grid[i][j];
            }
        }

        long[][] dp = new long[n + 1][3];

        for (int j = 0; j < n; j++) {
            long[][] nextDp = new long[n + 1][3];
            
            for (int h = 0; h <= n; h++) {
                for (int hPrev = 0; hPrev <= n; hPrev++) {
                    
                    long scoreJMinus1 = (j > 0 && h > hPrev) ? pref[j - 1][h] - pref[j - 1][hPrev] : 0;
                    nextDp[h][0] = Math.max(nextDp[h][0], Math.max(dp[hPrev][0], dp[hPrev][2]) + scoreJMinus1);

                    long scoreJ = (j > 0 && hPrev > h) ? pref[j][hPrev] - pref[j][h] : 0;
                    nextDp[h][1] = Math.max(nextDp[h][1], Math.max(dp[hPrev][0], dp[hPrev][1]) + scoreJ);

                    if (h == 0) {
                        nextDp[h][2] = Math.max(nextDp[h][2], Math.max(dp[hPrev][1], dp[hPrev][2]));
                    }
                }
            }
            dp = nextDp;
        }

        long maxScore = 0;
        for (int h = 0; h <= n; h++) {
            for (int s = 0; s < 3; s++) {
                maxScore = Math.max(maxScore, dp[h][s]);
            }
        }

        return maxScore;
    }
}