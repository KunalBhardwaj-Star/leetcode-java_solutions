class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length , n = obstacleGrid[0].length ;

        int[][] dp = new int[m + 1][n + 1];

        if(obstacleGrid[0][0] == 1)
            return 0;

        for(int i = 1 ; i <= m ; i++){
            for(int j = 1 ; j <= n ; j++){
                if(i - 1 == 0 && j - 1 == 0)
                    dp[i][j] = 1;

                else {
                    dp[i][j] = obstacleGrid[i-1][j-1] == 1 ? 0 : dp[i-1][j] + dp[i][j-1] ;
                }
            }
        }

        return dp[m][n];
    }
}