class Solution {
    public int rob(int[] nums) {
        int len = nums.length;

        if(len == 1)
            return nums[0];

        int prev2 = nums[0];
        int prev1 = Math.max(nums[1] , nums[0]);

        for(int i = 2; i < len ; i++){
            int current = Math.max(prev1 , prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}