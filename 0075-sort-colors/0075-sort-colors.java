class Solution {
    public void sortColors(int[] nums) {
        //By three pointer approach -->
        //init --> start ; pres --> current ; end --> last val
        int init = 0 , pres = 0;
        int end = nums.length-1;

        while(pres <= end){
            if(nums[pres] == 0){
                int temp = nums[init];
                nums[init] = nums[pres];
                nums[pres] = temp;
                init++;
                pres++;
            } else if(nums[pres] == 1){
                pres ++;
            } else {
                int temp = nums[end];
                nums[end] = nums[pres];
                nums[pres] = temp;
                end--;
            }
        }

    }
}