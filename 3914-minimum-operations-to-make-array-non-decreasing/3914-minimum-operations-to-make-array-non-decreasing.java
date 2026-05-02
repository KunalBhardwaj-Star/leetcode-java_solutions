class Solution {
    public long minOperations(int[] nums) {
        int len = nums.length;
        long count = 0 ;
        for(int i = 1 ; i < len ; i++) count += nums[i] < nums[i-1] ? nums[i - 1] - nums[i] : 0;

        return count;
    }
}