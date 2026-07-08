class Solution {
    static final long MOD = 1_000_000_007L;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + (s.charAt(i) - '0');
        }

        int m = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != '0') m++;
        }

        int[] pos = new int[m];
        int[] digit = new int[m];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch != '0') {
                pos[idx] = i;
                digit[idx] = ch - '0';
                idx++;
            }
        }

        long[] pow10 = new long[m + 1];
        pow10[0] = 1;
        for (int i = 1; i <= m; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        long[] pref = new long[m + 1];
        for (int i = 0; i < m; i++) {
            pref[i + 1] = (pref[i] * 10 + digit[i]) % MOD;
        }

        int[] ans = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int u = queries[q][0];
            int v = queries[q][1];

            long digitSum = prefixSum[v + 1] - prefixSum[u];

            int left = lowerBound(pos, u);
            int right = upperBound(pos, v) - 1;

            long numberWithoutZeros = 0;

            if (left <= right) {
                int len = right - left + 1;

                numberWithoutZeros =
                        (pref[right + 1]
                        - (pref[left] * pow10[len]) % MOD
                        + MOD) % MOD;
            }

            ans[q] = (int)((numberWithoutZeros * digitSum) % MOD);
        }

        return ans;
    }

    private int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}