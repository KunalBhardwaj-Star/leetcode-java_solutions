class Solution {
    private int search(int[] nums, int target, int l, int r) {
        if(l > r)
            return l;
        int mid = (l + r) / 2;
        if (target == nums[mid])
            return mid;

        if (target < nums[mid])
            return search(nums, target, l, mid - 1);
        else
            return search(nums, target, mid + 1, r);
    }

    public int searchInsert(int[] nums, int target) {
        int len = nums.length;

        return search(nums, target, 0, len - 1);
    }
}