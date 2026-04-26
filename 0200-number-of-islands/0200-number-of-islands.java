class Solution {
    private int [][] dir = {
        {1 , 0},
        {0 , 1},
        {-1 , 0},
        {0 , -1}
    };
    private void dfs(char[][] grid , boolean[][] vis , int r, int c){
        int n = grid.length , m = grid[0].length;

        if(r < 0 || c < 0 || r >= n || c >= m || vis[r][c] || grid[r][c] == '0') return;
        vis[r][c] = true;

        for(int[] d : dir){
            dfs(grid , vis , r + d[0] , c + d[1]);
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length , m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int count = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    dfs(grid , vis , i , j);
                    count++;
                }
            }        
        }

        return count;
    }
}