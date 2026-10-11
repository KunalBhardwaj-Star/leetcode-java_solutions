class Solution {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;

        int squareSum = 0;

        for(int idx = 0 ; idx < n ; idx++){
            if(n % (idx + 1) == 0)
                squareSum += nums[idx] * nums[idx];
        }

        return squareSum;
    }
}