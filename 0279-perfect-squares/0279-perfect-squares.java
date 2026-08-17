class Solution {
    public int numSquares(int n) {
        List<Integer> square = new ArrayList<>();

        int x = 1;

        while (x * x <= n){
            square.add(x * x);
            x++;
        }

        int[] dp = new int[n + 1];

        Arrays.fill(dp , Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 1; i <= n ; i++){
            for (int sq : square){
                if(i < sq)
                    break;

                dp[i]= Math.min(dp[i] , dp[i - sq] + 1);
            }
        }

        return dp[n];
    }
}