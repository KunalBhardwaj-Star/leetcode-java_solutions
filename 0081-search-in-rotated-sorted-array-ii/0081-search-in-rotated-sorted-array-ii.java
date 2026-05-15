class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;

        if (n == 0 && target != nums[0])
            return false;
        if (n == 0 && target == nums[0])
            return true;

        int l = 0, r = n - 1;

        while (l <= r) {
            if (nums[l] == target)
                return true;
            if (nums[r] == target)
                return true;

            l++;
            r--;
        }

        return false;
    }
}