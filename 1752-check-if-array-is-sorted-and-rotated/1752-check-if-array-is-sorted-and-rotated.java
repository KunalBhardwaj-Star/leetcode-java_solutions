class Solution {
    public boolean check(int[] nums) {
        int len = nums.length;

        int small = nums[0] , idx = 0;

        for(int i = 1 ; i < len ; i++){
            if(small >= nums[i]){
                small = nums[i];
                idx = nums[i-1] != nums[i] ? i : idx;
            }
        }

        if(idx == -1)
            return false;

        int count = 0 ; 

        for(int i = idx ; count < len - 1; i = (i + 1) % len){
            if(nums[(i + 1) % len] < nums[i])
                return false;
            
            count++;
        }

        return true;
    }
}