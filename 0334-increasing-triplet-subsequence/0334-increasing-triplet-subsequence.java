class Solution {
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        int first = Integer.MAX_VALUE , second = Integer.MAX_VALUE;

        // for(int i = 0 ; i < len ; i++){
        //     for(int j = i+1 ; j < len ; j++){
        //         for(int k = j + 1 ; k < len ; k++){
        //             if(nums[i] < nums[j] && nums[j] < nums[k]) return true;
        //         }
        //     }
        // }

        for(int n : nums){
            if(n <= first) first = n;
            else if(second >= n) second = n;
            else return true;
        }

        return false;
    }
}