class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        int sum = 0;

        for(int i = 0 ; i < n ; i++){
            dp[0] += (i * nums[i]);
            sum += nums[i];
        }
        for(int j = 1; j < n ; j++)
            dp[j] = dp[j - 1] + sum - (nums[n - j] * n);

        int max = Integer.MIN_VALUE;

        for(int k = 0 ; k < n ; k++)
            max = Math.max(max , dp[k]);

        return max;
    }
}