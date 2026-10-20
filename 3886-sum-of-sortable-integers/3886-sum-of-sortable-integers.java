
class Solution {

    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int d = 1; d * d <= n; d++) {
            if (n % d == 0) {
                if (isSortable(nums, d)) {
                    ans += d;
                }

                int other = n / d;

                if (other != d && isSortable(nums, other)) {
                    ans += other;
                }
            }
        }

        return ans;
    }

    private boolean isSortable(int[] nums, int k) {
        int n = nums.length;
        int prevMax = Integer.MIN_VALUE;

        for (int start = 0; start < n; start += k) {
            int end = start + k;

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int descents = 0;

            for (int i = start; i < end; i++) {
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i]);

                if (i + 1 < end && nums[i] > nums[i + 1]) {
                    descents++;
                }
            }

            if (nums[end - 1] > nums[start]) {
                descents++;
            }

            if (descents > 1) {
                return false;
            }

            if (prevMax > min) {
                return false;
            }

            prevMax = max;
        }

        return true;
    }
}
