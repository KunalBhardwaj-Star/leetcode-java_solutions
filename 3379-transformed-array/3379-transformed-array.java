class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for(int i = 0 ; i < n ; i++){
            int curr = nums[i];
            if(nums[i] == 0)result[i] = nums[i];
            else if(nums[i] > 0)result[i] = nums[(i + curr) % n];
            else {
                int targetIdx = i + nums[i];
                targetIdx = ((targetIdx % n) + n) % n;
                result[i] = nums[targetIdx];
            }
        }

        return result;
    }
}