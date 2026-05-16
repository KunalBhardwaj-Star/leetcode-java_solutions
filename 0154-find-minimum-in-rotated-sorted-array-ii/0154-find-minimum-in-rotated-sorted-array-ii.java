class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;

        int l = 0 , r = nums.length - 1;

        while(l <= r){
            min = Math.min(min , Math.min(nums[l] , nums[r]));
            l++;
            r--;
        }

        return min;
    }
}