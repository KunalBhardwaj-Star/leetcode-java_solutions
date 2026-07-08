class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        if(n == 1)
            return nums[0];

        int maxPro = nums[0];
        int minPro = nums[0];
        int result = nums[0];

        for(int i = 1 ; i < n ; i++){
            int temp = maxPro;

            maxPro = Math.max(nums[i] , Math.max(maxPro * nums[i] , nums[i] * minPro));

            minPro = Math.min(nums[i] , Math.min(temp * nums[i] , nums[i] * minPro));

            result = Math.max(result , maxPro);
        }

        return result;
    }
}