class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        int maxIdx = 0 , minIdx = 0;

        for(int i = 1; i < n ; i++){
            if(nums[maxIdx] < nums[i])
                maxIdx = i;

            if(nums[minIdx] > nums[i])
                minIdx = i;
        }

        int lft = Math.max(maxIdx , minIdx) + 1;
        int rght = n - Math.min(maxIdx , minIdx);
        int both = Math.min(maxIdx , minIdx) + 1 + n - Math.max(maxIdx , minIdx);

        return Math.min(lft , Math.min(rght , both));
    }
}