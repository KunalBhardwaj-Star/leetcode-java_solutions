class Solution {
    public int[] separateDigits(int[] nums) {
        int len = nums.length;

        int ans_len = 0;
        String s = "";

        for (int i = 0; i < len; i++) {
            ans_len += (nums[i] + "").length();
            s += nums[i];
        }

        int[] ans = new int[ans_len];

        for (int i = 0; i < ans_len; i++)
            ans[i] = s.charAt(i) - '0';

        return ans;
    }
}