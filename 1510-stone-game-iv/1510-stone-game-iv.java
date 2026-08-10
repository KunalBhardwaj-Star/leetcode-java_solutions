class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n+1];

        dp[0] = false;

        for(int i = 1 ; i <= n ; i++){
            dp[i] = false;

            for(int sq = 1 ; sq * sq <=  n ; sq++){
                int square = sq * sq;

                if(square > i)
                    break;

                int remaining = i - square;

                if(!dp[remaining]){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}