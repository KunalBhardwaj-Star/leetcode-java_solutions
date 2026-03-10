class Solution {
    private static final int MOD = 1000000007;

    public int numberOfStableArrays(int zero, int one, int limit) {
        // dp[i][j][0] = ways to have i zeros, j ones, ending in 0
        // dp[i][j][1] = ways to have i zeros, j ones, ending in 1
        long[][][] dp = new long[zero + 1][one + 1][2];

        // Base cases: if we only use one type of digit, it's 1 way 
        // as long as it's within the limit.
        for (int i = 1; i <= Math.min(zero, limit); i++) dp[i][0][0] = 1;
        for (int j = 1; j <= Math.min(one, limit); j++) dp[0][j][1] = 1;

        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                
                // Ways to end with 0:
                // Previous could have ended in 0 or 1
                dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % MOD;
                if (i > limit) {
                    // Inclusion-Exclusion: subtract invalid sequences where 
                    // we exceeded the limit of consecutive zeros.
                    dp[i][j][0] = (dp[i][j][0] - dp[i - limit - 1][j][1] + MOD) % MOD;
                }

                // Ways to end with 1:
                // Previous could have ended in 0 or 1
                dp[i][j][1] = (dp[i][j - 1][0] + dp[i][j - 1][1]) % MOD;
                if (j > limit) {
                    // Subtract invalid sequences where we exceeded the limit of consecutive ones.
                    dp[i][j][1] = (dp[i][j][1] - dp[i][j - limit - 1][0] + MOD) % MOD;
                }
            }
        }

        return (int) ((dp[zero][one][0] + dp[zero][one][1]) % MOD);
    }
}