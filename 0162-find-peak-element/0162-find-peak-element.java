class Solution {
    public int findPeakElement(int[] nums) {
        int len = nums.length;

        if(len == 1) return 0;

        int i = 0 , j = 1;

        while(j < len){
            if(nums[j] - nums[i] < 0) return i;
            i++;
            j++;
        }

        return len-1;
    }
}