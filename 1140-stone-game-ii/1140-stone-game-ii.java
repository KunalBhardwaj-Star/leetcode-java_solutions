class Solution {
    private int solve(int i , int M , int n , int[] suffix , int[][] dp){
        if(i == n)
            return 0;

        if(2 * M >= n - i)
            return suffix[i];

        if(dp[i][M] != -1)
            return dp[i][M];

        int best = 0;

        for(int X = 1 ; X <= Math.min(2 * M , n - i) ; X++){
            int newM = Math.max(M , X);

            int oppStone = solve(i + X , newM , n , suffix , dp);

            int currStone = suffix[i] - oppStone;

            best = Math.max(best , currStone);
        }

        return dp[i][M] = best;
    }
    public int stoneGameII(int[] piles) {
        int n = piles.length;

        int[] suffix = new int[n+1];

        for(int i = n-1 ; i >= 0 ; i--){
            suffix[i] = suffix[i+1] + piles[i];
        }

        int[][] dp = new int[n][n+1];

        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dp[i] , -1);
        }

        return solve(0, 1, n, suffix, dp);
    }
}