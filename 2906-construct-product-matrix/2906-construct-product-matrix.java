class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int mod = 12345;

        int total = n * m;
        int[] arr = new int[total];

        // Flatten grid
        for (int i = 0; i < total; i++) {
            arr[i] = grid[i / m][i % m] % mod;
        }

        int[] prefix = new int[total];
        int[] suffix = new int[total];

        prefix[0] = 1;
        for (int i = 1; i < total; i++) {
            prefix[i] = (int)((long)prefix[i - 1] * arr[i - 1] % mod);
        }

        suffix[total - 1] = 1;
        for (int i = total - 2; i >= 0; i--) {
            suffix[i] = (int)((long)suffix[i + 1] * arr[i + 1] % mod);
        }

        int[][] result = new int[n][m];

        for (int i = 0; i < total; i++) {
            int val = (int)((long)prefix[i] * suffix[i] % mod);
            result[i / m][i % m] = val;
        }

        return result;
    }
}