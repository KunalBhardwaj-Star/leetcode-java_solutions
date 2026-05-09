class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {

            ArrayList<Integer> nums = new ArrayList<>();

            int top = layer;
            int left = layer;
            int bottom = m - layer - 1;
            int right = n - layer - 1;

            for (int j = left; j <= right; j++) {
                nums.add(grid[top][j]);
            }

            for (int i = top + 1; i <= bottom; i++) {
                nums.add(grid[i][right]);
            }

            for (int j = right - 1; j >= left; j--) {
                nums.add(grid[bottom][j]);
            }

            for (int i = bottom - 1; i > top; i--) {
                nums.add(grid[i][left]);
            }

            int size = nums.size();
            int rotate = k % size;

            int idx = 0;

            for (int j = left; j <= right; j++) {
                grid[top][j] = nums.get((idx + rotate) % size);
                idx++;
            }

            for (int i = top + 1; i <= bottom; i++) {
                grid[i][right] = nums.get((idx + rotate) % size);
                idx++;
            }

            for (int j = right - 1; j >= left; j--) {
                grid[bottom][j] = nums.get((idx + rotate) % size);
                idx++;
            }

            for (int i = bottom - 1; i > top; i--) {
                grid[i][left] = nums.get((idx + rotate) % size);
                idx++;
            }
        }

        return grid;
    }
}