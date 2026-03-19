class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0 ;
        int len = nums.length;

        while(i < len){
            if(nums[i] == 0){
                for(int j = i+1 ; j < len ; j++){
                    if(nums[j] != 0){
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
            i++;
        }
    }
}