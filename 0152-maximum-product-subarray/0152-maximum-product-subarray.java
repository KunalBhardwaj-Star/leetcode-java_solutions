class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;

        int maxPro = Integer.MIN_VALUE;
        int minPro = Integer.MAX_VALUE;

        int result = Integer.MIN_VALUE;

        for(int i = 0 ; i < len ; i++){
            int temp = maxPro;

            maxPro = maxPro == Integer.MIN_VALUE ? nums[i] : Math.max(nums[i] , Math.max(maxPro * nums[i] , minPro * nums[i]));
            minPro = minPro == Integer.MAX_VALUE ? nums[i] :  Math.min(nums[i] , Math.min(temp * nums[i] , nums[i] * minPro));

            result = Math.max(maxPro , result);
        }

        return result;
    }
}