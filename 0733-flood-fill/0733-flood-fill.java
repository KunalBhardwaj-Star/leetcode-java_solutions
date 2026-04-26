class Solution {
    private int[][] dir = {
        {1 , 0},
        {0 , 1},
        {-1 , 0},
        {0 , -1}
    };
    private void dfs(int[][] image, boolean[][]vis, int sr, int sc, int color , int curr){
        int n = image.length , m = image[0].length;

        if(sr < 0 || sc < 0 || sr >= n || sc >= m || vis[sr][sc] || image[sr][sc] != curr) return;

        vis[sr][sc] = true;
        image[sr][sc] = color;

        for(int[] d : dir){
            dfs(image , vis , sr + d[0] , sc + d[1] , color , curr);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length , m = image[0].length;
        boolean[][]vis = new boolean[n][m];

        if(image[sr][sc] == color) return image;

        dfs(image , vis , sr , sc , color , image[sr][sc]);
        return image;
    }
}