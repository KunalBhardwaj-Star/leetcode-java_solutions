class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;

        int ans = Integer.MAX_VALUE;

        int lft = 0;

        for(int rght = 0 ; rght < nums.length ; rght++){
            sum += nums[rght];

           while(sum >= target) {
                ans = Math.min(ans, rght - lft + 1);
                sum -= nums[lft++];
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}