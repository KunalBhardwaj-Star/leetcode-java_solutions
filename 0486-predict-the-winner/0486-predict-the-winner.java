class Solution {
    private int[][] dp;

    private int solve(int i, int j, int[] nums) {
        if (i == j) return nums[i];

        if (dp[i][j] != Integer.MIN_VALUE)
            return dp[i][j];

        int takeLeft = nums[i] - solve(i + 1, j, nums);
        int takeRight = nums[j] - solve(i, j - 1, nums);

        return dp[i][j] = Math.max(takeLeft, takeRight);
    }

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;

        dp = new int[n][n];

        for (int[] row : dp)
            Arrays.fill(row, Integer.MIN_VALUE);

        return solve(0, n - 1, nums) >= 0;
    }
}