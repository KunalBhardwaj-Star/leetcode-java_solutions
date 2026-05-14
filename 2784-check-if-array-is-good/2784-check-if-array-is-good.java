class Solution {
    public boolean isGood(int[] nums) {
        int len = nums.length;

        int max = 0;

        for (int i = 0; i < len; i++)
            max = Math.max(max, nums[i]);

        if (len <= max || len > max + 1)
            return false;

        int[] count = new int[max + 1];

        for (int i = 0; i < len; i++) {
            int curr = nums[i];

            if (count[curr] != 0 && curr != len - 1)
                return false;
            else
                count[curr]++;
        }

        for (int i = 1; i <= max; i++)
            if (count[i] == 0 && i != max || count[i] > 1 && i != max)
                return false;

        return true;
    }
}