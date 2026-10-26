
class Solution {
    boolean[][] vis;

    private long dfs(int[][] grid, int r, int c) {
        int m = grid.length, n = grid[0].length;

        if (r < 0 || r >= m || c < 0 || c >= n
                || vis[r][c] || grid[r][c] == 0) {
            return 0L;
        }

        vis[r][c] = true;

        long sum = grid[r][c];

        sum += dfs(grid, r - 1, c);
        sum += dfs(grid, r + 1, c);
        sum += dfs(grid, r, c - 1);
        sum += dfs(grid, r, c + 1);

        return sum;
    }

    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        vis = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0 && !vis[i][j]) {
                    long sum = dfs(grid, i, j);

                    if (sum % k == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
