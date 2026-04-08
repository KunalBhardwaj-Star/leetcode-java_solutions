class Solution {
    static final int MOD = 1_000_000_007;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;

        long[] mul = new long[n];
        Arrays.fill(mul, 1);

        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];

            for (int idx = l; idx <= r; idx += k) {
                mul[idx] = (mul[idx] * v) % MOD;
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            long val = (nums[i] * mul[i]) % MOD;
            ans ^= (int) val;
        }

        return ans;
    }
}