class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;

       int[] prefix = new int[len];
       int[] suffix = new int[len];

       prefix[len-1] = 1;
       suffix[0] = 1;

       for(int i = len-2 ; i >= 0 ; i--) prefix[i] = prefix[i+1] * nums[i+1];
       for(int j = 1 ; j < len ; j++) suffix[j] = suffix[j-1] * nums[j-1];

        for(int k = 0 ; k < len ; k++) nums[k] = suffix[k] * prefix[k];

        return nums;
    }
}