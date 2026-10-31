
class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int MOD = 1_000_000_007;

        int[][] rght = new int[m][n];
        int[][] down = new int[m][n];

        rght[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                long r = rght[i][j];
                long d = down[i][j];

                if (i == 0 && j == 0 || grid[i][j] == 0) {

                    if (j + 1 < n) {
                        rght[i][j + 1] = (int)(
                            (rght[i][j + 1] + r + d) % MOD
                        );
                    }

                    if (i + 1 < m) {
                        down[i + 1][j] = (int)(
                            (down[i + 1][j] + r + d) % MOD
                        );
                    }

                } else {

                    if (i + 1 < m) {
                        down[i + 1][j] = (int)(
                            (down[i + 1][j] + r) % MOD
                        );
                    }

                    if (j + 1 < n) {
                        rght[i][j + 1] = (int)(
                            (rght[i][j + 1] + d) % MOD
                        );
                    }
                }
            }
        }

        return (int)(
            ((long) rght[m - 1][n - 1] +
             down[m - 1][n - 1]) % MOD
        );
    }
}
