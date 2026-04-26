class Solution {
    private int[][] dir = {
        {1 , 0},
        {0 , 1},
        {-1 , 0},
        {0 , -1}
    };

    private boolean dfs(char[][] grid , boolean[][] vis , int r , int c , int pr , int pc){
        vis[r][c] = true;

        for(int [] d : dir){
            int nr = r + d[0] , nc = c + d[1];
            if(nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length) continue;

            if(grid[nr][nc] != grid[r][c]) continue;

            if(nr == pr && nc == pc) continue;

            if(vis[nr][nc]) return true;

            if(dfs(grid , vis , nr , nc , r, c)) return true;
        }

        return false;
    }

    public boolean containsCycle(char[][] grid) {
        int n = grid.length , m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < m ; j++){
                if(!vis[i][j]){
                    if(dfs(grid , vis , i , j , -1 , -1)) return true;
                }
            }
        }

        return false;
    }
}