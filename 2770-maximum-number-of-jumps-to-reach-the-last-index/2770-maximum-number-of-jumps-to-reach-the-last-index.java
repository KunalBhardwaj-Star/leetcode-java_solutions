class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;

        int dp[] = new int[n];
        Arrays.fill(dp , -1);
        dp[0] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((-target <= nums[j] - nums[i]) && (nums[j] - nums[i] <= target) && dp[i] != -1) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }

            }
        }

        return dp[n - 1];
    }
}