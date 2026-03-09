class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {

        int MOD = 1_000_000_007;

        int[][] dp0 = new int[zero+1][one+1];
        int[][] dp1 = new int[zero+1][one+1];

        for(int i = 0 ; i <= zero ; i++)
            dp0[i][0] = i <= limit ? 1 : 0;

        for(int j = 0 ; j <= one ; j++)
            dp1[0][j] = j <= limit ? 1 : 0;

        for(int i = 1 ; i <= zero ; i++){
            for(int j = 1 ; j <= one ; j++){

                for (int k = 1; k <= limit; k++) {
                    if (i - k >= 0)
                        dp0[i][j] = (dp0[i][j] + dp1[i - k][j]) % MOD;
                }

                for (int k = 1; k <= limit; k++) {
                    if (j - k >= 0)
                        dp1[i][j] = (dp1[i][j] + dp0[i][j - k]) % MOD;
                }

            }
        }

        return (dp0[zero][one] + dp1[zero][one]) % MOD;
    }
}