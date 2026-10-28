import java.util.*;

class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        Set<Integer>[][] dp = new HashSet[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new HashSet<>();
            }
        }

        dp[0][0].add(grid[0][0]);

        for (int i = 1; i < m; i++) {
            for (int x : dp[i - 1][0]) {
                dp[i][0].add(x ^ grid[i][0]);
            }
        }

        for (int j = 1; j < n; j++) {
            for (int x : dp[0][j - 1]) {
                dp[0][j].add(x ^ grid[0][j]);
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                for (int x : dp[i][j - 1]) {
                    dp[i][j].add(x ^ grid[i][j]);
                }

                for (int x : dp[i - 1][j]) {
                    dp[i][j].add(x ^ grid[i][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for (int x : dp[m - 1][n - 1]) {
            min = Math.min(min, x);
        }

        return min;
    }
}