class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length() , m = p.length();
        boolean[][] dp = new boolean[n+1][m+1];

        //initialization
        dp[0][0] = true;
        //for column = 0 and varying row we always get false bcz if pattern len = 0 then for any len of string we get false --> no need to initialize (i , 0) always 0.
        for(int i = 1; i < n+1 ; i++){
            dp[i][0] = false;
        }
        for(int j = 1 ; j < m+1 ; j++){
            if(p.charAt(j-1) == '*'){ dp[0][j] =dp[0][j-1];}
        }

        //bottom-up-manner
        for(int i = 1; i < n+1 ; i++){
            for(int j = 1; j < m+1 ; j++){
                //if characters are same or pattern character is ?
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1) == '*'){ //if character in p is *
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                } else{ //None of the above case
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }
}