class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {
            int v = num % k;

            long[] ndp = new long[k];

            ndp[v]++;

            for (int r = 0; r < k; r++) {
                if (dp[r] == 0) continue;

                int nr = (r * v) % k;
                ndp[nr] += dp[r];
            }

            for (int r = 0; r < k; r++) {
                ans[r] += ndp[r];
            }

            dp = ndp;
        }

        return ans;
    }
}