class Solution {
    public int maxRotateFunction(int[] nums) {
        int len = nums.length;

        int f[] = new int[len];

        int sum = 0 ;

        for(int i = 0 ; i < len ; i ++){
            f[0] += (i * nums[i]);
            sum += nums[i];
        }

        for(int i = 1; i < len ; i++) f[i] = f[i - 1] + sum - len * nums[len - i];

        int max = Integer.MIN_VALUE;

        for(int i = 0 ; i < len ; i++) max = Math.max(max , f[i]);

        return max;
    }
}