class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int len = nums.length;
        int[] max = new int[len];
        int[] min = new int[len];

        max[0] = nums[0];
        min[len - 1] = nums[len - 1];

        for(int i = 1 ; i < len ; i++){
            max[i] = Math.max(nums[i] , max[i-1]);
        }

        for(int i = len - 2 ; i >= 0 ; i--){
            min[i] = Math.min(nums[i] , min[i+1]);
        }

        // int idx = -1 , min_val = Integer.MAX_VALUE;

        // for(int i = len - 1 ; i >= 0 ; i--){
        //     if(max[i] - min[i] <= k){
        //         if(max[i] - min[i] == min_val) idx = Math.min(idx , i);
        //         else if(max[i] - min[i] < min_val) idx = i;
        //         min_val = Math.min(min_val , max[i] - min[i]);
        //     }
        // }

        int stable_score[] = new int[len];

        for(int i = 0 ; i < len ; i++) stable_score[i] = max[i] - min[i];

        for(int i = 0 ; i < len ; i++){
            if(stable_score[i] <= k) return i;
        }

        return -1;
    }
}