class Solution {
    public int rob(int[] nums) {
        int len = nums.length;

        if(len == 1)
            return nums[0];

        if(len == 2)
            return Math.max(nums[0] , nums[1]);

        // include first , exclude last
        int max1 = findMax(nums , 0 , len - 2);

        // exclude first , include last
        int max2 = findMax(nums , 1 , len - 1);

        return Math.max(max1 , max2);
    }

    private int findMax(int[] nums , int start , int end){
        int prev2 = nums[start];
        int prev1 = Math.max(nums[start] , nums[start + 1]);

        for(int i = start + 2 ; i <= end ; i++){
            int current = Math.max(prev1 , prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}