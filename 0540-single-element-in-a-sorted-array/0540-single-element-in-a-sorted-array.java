class Solution {
    public int singleNonDuplicate(int[] nums) {
        int len = nums.length;

        if(len == 1) return nums[0];

        int i = 0;

        for(i = 0 ; i < len - 1 ; i = i + 2){
            if(nums[i] != nums[i+1]) return nums[i];
        }

        return i == len ? nums[i-1] : nums[i];
    }
}