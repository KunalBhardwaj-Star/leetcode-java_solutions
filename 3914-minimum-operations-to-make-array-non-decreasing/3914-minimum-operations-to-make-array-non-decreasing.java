class Solution {
    public long minOperations(int[] nums) {
        int len = nums.length;
        long ans = 0;

        for(int i = 0 ; i < len - 1 ; i++){
            if(nums[i]  > nums[i + 1] ) ans += nums[i] - nums[i + 1];
        }

        return ans;
    }
}