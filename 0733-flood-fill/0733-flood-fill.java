class Solution {
    private int[][] dir = {
        {-1 , 0},
        {0 , -1},
        {1 , 0},
        {0 , 1}
    };

    private void dfs(int[][] image , boolean[][] vis , int r , int c ,int color , int curr){
        if(r < 0 || r >= image.length || c < 0 || c >= image[0].length || vis[r][c] || image[r][c] != curr) return;

        vis[r][c] = true;
        image[r][c] = color;

        for(int[] d : dir){
            dfs(image , vis , r + d[0] , c + d[1], color , curr);
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int row = image.length , col = image[0].length;

        boolean[][] vis = new boolean[row][col];

        dfs(image , vis , sr , sc , color , image[sr][sc]);

        return image;
    }
}