class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxReach = 0;

        for(int i = 0 ; i < n && i <= maxReach ; i++){
            maxReach = Math.max(maxReach , i + nums[i]);

            if(maxReach >= n - 1){
                return true;
            }
        }

        return false;
    }
}