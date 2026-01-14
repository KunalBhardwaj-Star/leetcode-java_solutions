class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0 , curr = 0;
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] == 1) {
                curr += 1;
                max = Math.max(max , curr);
            }
            else curr = 0;
        }
        return max;
    }
}