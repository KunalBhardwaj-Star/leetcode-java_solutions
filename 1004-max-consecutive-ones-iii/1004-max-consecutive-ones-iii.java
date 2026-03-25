class Solution {
    public int longestOnes(int[] nums, int k) {
        int len = nums.length;

        int i = 0 , j = 0 , max = 0 , zeroCount = 0;
        // while(i < len){
        //     int curr = k , count = 0;
        //     while(curr > 0  && j < len){
        //         count ++;
        //     }
        //     i = j;
        //     max = Math.max(max , count);
        // }

        for(j = 0 ; j < len ; j++){
            if(nums[j] == 0) zeroCount++;

            while(zeroCount > k){
                if(nums[i] == 0) zeroCount--;
                i++;
            }

            max = Math.max(max , j - i + 1);
        }

        return max;
    }
}