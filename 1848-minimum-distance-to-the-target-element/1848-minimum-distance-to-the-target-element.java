class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int len = nums.length;

        if(len == 1 || (nums[0] == target && start == 0) || (nums[start] == target)) return 0;

        // int idx = 0;

        // while(idx < len){
        //     if(nums[idx] == target){

        //     }
        //     idx++;
        // }


        int ans = Integer.MAX_VALUE;

        for(int i = 0 ; i < len ; i++){
            if(nums[i] == target){
                ans = Math.min(Math.abs(start - i) , ans);
            }
        }

        return ans;
    }
}