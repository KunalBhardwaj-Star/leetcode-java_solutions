import java.util.*;

class Solution {
    public int[] getBiggestThree(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        TreeSet<Integer> set = new TreeSet<>();

        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){

                set.add(grid[r][c]); // single cell

                for(int k = 1; r + 2*k < m && c - k >= 0 && c + k < n; k++){

                    int sum = 0;

                    // left edge
                    for(int i=0;i<k;i++)
                        sum += grid[r+i][c-i];

                    // bottom-left to bottom
                    for(int i=0;i<k;i++)
                        sum += grid[r+k+i][c-k+i];

                    // right edge
                    for(int i=0;i<k;i++)
                        sum += grid[r+2*k-i][c+i];

                    // top-right edge
                    for(int i=0;i<k;i++)
                        sum += grid[r+k-i][c+k-i];

                    set.add(sum);
                }
            }
        }

        int size = Math.min(3, set.size());
        int[] ans = new int[size];

        for(int i=0;i<size;i++)
            ans[i] = set.pollLast();

        return ans;
    }
}