class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int maxVal = 0;
        for (int x : nums) maxVal = Math.max(maxVal, x);

        int[] freq = new int[maxVal + 1];
        for (int x : nums) freq[x]++;

        long[] exact = new long[maxVal + 1];

        for (int g = maxVal; g >= 1; g--) {
            long cnt = 0;

            for (int multiple = g; multiple <= maxVal; multiple += g) {
                cnt += freq[multiple];
            }

            long pairs = cnt * (cnt - 1) / 2;

            for (int multiple = g * 2; multiple <= maxVal; multiple += g) {
                pairs -= exact[multiple];
            }

            exact[g] = pairs;
        }

        long[] prefix = new long[maxVal + 1];
        for (int i = 1; i <= maxVal; i++) {
            prefix[i] = prefix[i - 1] + exact[i];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long k = queries[i];

            int lo = 1, hi = maxVal;

            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;

                if (prefix[mid] > k)
                    hi = mid;
                else
                    lo = mid + 1;
            }

            ans[i] = lo;
        }

        return ans;
    }
}