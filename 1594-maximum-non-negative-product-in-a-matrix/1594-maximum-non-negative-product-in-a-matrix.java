class Solution {
    public int maxProductPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        long[][] maxDp = new long[n][m];
        long[][] minDp = new long[n][m];
        
        maxDp[0][0] = grid[0][0];
        minDp[0][0] = grid[0][0];
        
        // first column
        for(int i = 1; i < n; i++){
            maxDp[i][0] = maxDp[i-1][0] * grid[i][0];
            minDp[i][0] = maxDp[i][0];
        }
        
        // first row
        for(int j = 1; j < m; j++){
            maxDp[0][j] = maxDp[0][j-1] * grid[0][j];
            minDp[0][j] = maxDp[0][j];
        }
        
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                
                long val = grid[i][j];
                
                long a = val * maxDp[i-1][j];
                long b = val * minDp[i-1][j];
                long c = val * maxDp[i][j-1];
                long d = val * minDp[i][j-1];
                
                maxDp[i][j] = Math.max(Math.max(a, b), Math.max(c, d));
                minDp[i][j] = Math.min(Math.min(a, b), Math.min(c, d));
            }
        }
        
        long res = maxDp[n-1][m-1];
        int MOD = 1000000007;
        
        if(res < 0) return -1;
        return (int)(res % MOD);
    }
}