class Solution {
    public int[] leftRightDifference(int[] nums) {
        int len = nums.length;

        if(len == 1)
            return new int[]{0};

        int[] leftSum = new int[len];
        leftSum[0] = 0;

        int[] rightSum = new int[len];
        rightSum[len-1] = 0;

        for(int i = 1 ; i < len ; i++){
            leftSum[i] = leftSum[i-1] + nums[i-1];
            rightSum[len-i-1] = rightSum[len-i] + nums[len-i];
        }

        for(int i = 0 ; i < len ; i++){
            nums[i] = Math.abs(leftSum[i] - rightSum[i]);
        }

        return nums;
    }
}