class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;

        int total = 0;

        for (int a : nums) {
            total += a;
        }

        int target = total - x;

        if (target < 0) {
            return -1;
        }

        int lft = 0;
        int rght = 0;
        int sum = 0;
        int maxLen = -1;

        while (rght < n) {
            sum += nums[rght];

            while (sum > target) {
                sum -= nums[lft++];
            }

            if (sum == target) {
                maxLen = Math.max(maxLen, rght - lft + 1);
            }

            rght++;
        }

        return maxLen == -1 ? -1 : n - maxLen;
    }
}