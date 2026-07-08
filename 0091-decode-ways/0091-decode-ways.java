class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        if(n == 0 || s.charAt(0) == '0')
            return 0;

        int[] dp = new int[n];
        dp[0] = 1;

        for(int i = 1; i < n ; i++){
            if(s.charAt(i) >= '1' && s.charAt(i) <= '9')
                dp[i] += dp[i-1];

            int twoDig = Integer.parseInt(s.substring(i-1 , i+1));

            if(twoDig >= 10 && twoDig <= 26)
                dp[i] += i > 1 ? dp[i-2] : dp[i-1];
        }

        return dp[n-1];
    }
}