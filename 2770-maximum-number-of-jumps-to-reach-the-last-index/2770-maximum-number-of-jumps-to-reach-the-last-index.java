class Solution {
    public int maximumJumps(int[] nums, int target) {
        int len = nums.length;

        if (len == 0)
            return 0;

        int[] dp = new int[len];

        Arrays.fill(dp , -1);

        dp[0] = 0;

        for (int i = 1; i < len; i++) {
            for(int j = 0 ; j  < i ; j++){
                int diff = nums[j] - nums[i];

                if(dp[j] != -1 && diff <= target && -target <= diff)
                    dp[i] = Math.max(dp[i] , dp[j] + 1);
            }
        }

        return dp[len - 1] ;
    }
}