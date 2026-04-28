import java.util.*;

class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length, m = grid[0].length;

        ArrayList<Integer> list = new ArrayList<>();

        for (int[] row : grid) {
            for (int val : row) {
                list.add(val);
            }
        }

        Collections.sort(list);

        int mid = list.get(list.size() / 2);

        int operations = 0;

        for (int val : list) {
            int diff = Math.abs(val - mid);

            if (diff % x != 0) return -1;

            operations += diff / x;
        }

        return operations;
    }
}