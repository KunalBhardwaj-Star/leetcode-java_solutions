class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] trailingZeros = new int[n];

        // 1. Pre-calculate trailing zeros for each row
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) count++;
                else break;
            }
            trailingZeros[i] = count;
        }

        int swaps = 0;
        // 2. Greedy selection and shifting
        for (int i = 0; i < n; i++) {
            int target = n - 1 - i;
            int foundIdx = -1;

            // Find the first row that satisfies the target
            for (int j = i; j < n; j++) {
                if (trailingZeros[j] >= target) {
                    foundIdx = j;
                    break;
                }
            }

            if (foundIdx == -1) return -1;

            // Accumulate swaps and perform the shift
            swaps += (foundIdx - i);
            int tempValue = trailingZeros[foundIdx];
            for (int k = foundIdx; k > i; k--) {
                trailingZeros[k] = trailingZeros[k - 1];
            }
            trailingZeros[i] = tempValue;
        }

        return swaps;
    }
}