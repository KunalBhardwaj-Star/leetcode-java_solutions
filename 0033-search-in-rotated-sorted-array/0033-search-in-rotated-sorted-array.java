class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        if (n == 1 && nums[0] != target)
            return -1;
        if (n == 1 && nums[0] == target)
            return 0;

        int l = 0, r = n - 1;

        while (l <= r) {
            if (nums[l] == target)
                return l;
            if (nums[r] == target)
                return r;

            l++;
            r--;
        }

        return -1;
    }
}