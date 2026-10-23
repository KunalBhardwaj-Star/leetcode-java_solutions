class Solution {
    public int sortPermutation(int[] nums) {
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length ; i++){
            if(i != nums[i])
                ans = ans == Integer.MAX_VALUE ? nums[i] : ans & nums[i];
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}