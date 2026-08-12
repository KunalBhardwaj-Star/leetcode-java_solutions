class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer , Integer> freq = new HashMap<>();

        int n = nums.length;

        int maxSize = 0;

        int l = 0;

        for(int r = 0 ; r < n ; r++){
            freq.put(nums[r] , freq.getOrDefault(nums[r] , 0) + 1);

            while(freq.get(nums[r]) > k){
                freq.put(nums[l] , freq.get(nums[l]) - 1);
                l++;
            }

            maxSize = Math.max(maxSize , r - l + 1);
        }

        return maxSize;
    }
}