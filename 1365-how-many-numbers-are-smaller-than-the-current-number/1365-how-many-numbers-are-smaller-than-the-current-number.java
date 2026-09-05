class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;

        int[] mx = new int[n];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(nums[i] > nums[j]){
                    mx[i] += 1;
                }
            }
        }

        return mx;
    }
}