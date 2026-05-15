class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;

        if (n == 1)
            return nums[0];

        int min = Integer.MAX_VALUE;

        int l = 0, r = n - 1;

        while (l <= r) {
            min = Math.min(min, Math.min(nums[l], nums[r]));
            l++;
            r--;
        }

        return min;
    }
}