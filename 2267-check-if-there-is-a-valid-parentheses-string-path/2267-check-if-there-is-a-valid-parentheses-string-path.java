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

        return dp[i][j][bal] = isValidExist(grid , i + 1 , j , bal) || isValidExist(grid , i , j + 1, bal);
    }

    public boolean hasValidPath(char[][] grid) {
        int m = grid.length , n = grid[0].length;

        if(grid[0][0] == ')' || grid[m-1][n-1] == '(')
            return false;

        if(((m+n -1) & 1) == 1)
            return false;

        int maxBal = m + n + 1;

        dp = new Boolean[m][n][maxBal];

        return isValidExist(grid , 0 , 0 , 0);
    }
}