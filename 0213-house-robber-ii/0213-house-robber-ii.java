class Solution {
    public int rob(int[] nums) {
        int len = nums.length;

        if(len == 1)
            return nums[0];

        if(len == 2)
            return Math.max(nums[0] , nums[1]);

        int prev2S = nums[0];
        int prev1S = Math.max(nums[0] , nums[1]);

        for(int i = 2 ; i < len - 1 ; i++){
            int current = Math.max(prev1S , prev2S + nums[i]);
            prev2S = prev1S;
            prev1S = current;
        }

        int prev2L = nums[1];
        int prev1L = Math.max(nums[1] , nums[2]);

        for(int i = 3 ; i < len ; i++){
            int current = Math.max(prev1L , prev2L + nums[i]);
            prev2L = prev1L;
            prev1L = current;
        }

        return Math.max(prev1S , prev1L);

    }
}