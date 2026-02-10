class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0 , N = nums.length;
        for(int x : nums) sum += x;
        if(sum % 2 != 0) return false;
        int t = sum/2;
        
        boolean[][] dp = new boolean[N + 1][t + 1];

        for(int i = 0 ; i <= N ; i++){
            dp[i][0] = true;
        }

        for(int n = 1 ; n <= N ; n++){
            for(int tar = 1 ; tar <= t ; tar++){
                if(nums[n-1] <= tar){//valid
                    dp[n][tar] = dp[n-1][tar] || dp[n-1][tar - nums[n-1]];
                } else dp[n][tar] = dp[n-1][tar];
            }
        }

        return dp[N][t];
    }
}