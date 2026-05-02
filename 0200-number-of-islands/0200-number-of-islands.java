class Solution {
    int[][] dir = {
        {-1 , 0},
        {0 , -1},
        {1 , 0},
        {0 , 1}
    };

    private void dfs(char[][] grid , boolean[][] vis , int r , int c){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || vis[r][c] || grid[r][c] == '0') return;

        vis[r][c] = true;

        for(int[] d : dir){
            dfs(grid , vis , r + d[0] , c + d[1]);
        }
    }

    public int numIslands(char[][] grid) {
        int row = grid.length , col = grid[0].length;
        boolean[][] vis = new boolean[row][col];
        int count = 0;
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    dfs(grid , vis , i , j);
                    count++;
                }
            }
        }

        return count;
    }
}