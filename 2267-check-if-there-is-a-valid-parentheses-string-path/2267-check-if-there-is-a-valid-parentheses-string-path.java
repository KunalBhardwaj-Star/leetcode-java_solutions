class Solution {

    Boolean[][][] dp;

    private boolean isValidExist(char[][] grid , int i , int j , int bal){
        if(i >= grid.length || j >= grid[0].length)
            return false;

        bal += grid[i][j] == '(' ? 1 : -1;

        if(bal < 0)
            return false;

        if(i == grid.length - 1 && j == grid[0].length - 1)
            return bal == 0;

        if(dp[i][j][bal] != null)
            return dp[i][j][bal];

        return dp[i][j][bal] = isValidExist(grid , i + 1 , j , bal) || isValidExist(grid , i , j + 1 , bal);
    }

    public boolean hasValidPath(char[][] grid) {
        int m = grid.length , n = grid[0].length;
        int maxBal = m + n + 1;

        if(((m+n-1) & 1) == 1)
            return false;

        dp = new Boolean[m][n][maxBal];

        return isValidExist(grid , 0 , 0 , 0);
    }
}