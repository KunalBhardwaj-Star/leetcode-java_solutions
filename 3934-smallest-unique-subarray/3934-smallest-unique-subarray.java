
import java.util.*;

class Solution {

    static final long MOD1 = 1_000_000_007L;
    static final long MOD2 = 1_000_000_009L;

    static final long BASE1 = 911382323L;
    static final long BASE2 = 972663749L;

    public int smallestUniqueSubarray(int[] nums) {

        int n = nums.length;

        long[] pref1 = new long[n + 1];
        long[] pref2 = new long[n + 1];

        long[] pow1 = new long[n + 1];
        long[] pow2 = new long[n + 1];

        pow1[0] = 1;
        pow2[0] = 1;

        for (int i = 0; i < n; i++) {

            pref1[i + 1] =
                (pref1[i] * BASE1 + nums[i]) % MOD1;

            pref2[i + 1] =
                (pref2[i] * BASE2 + nums[i]) % MOD2;

            pow1[i + 1] = (pow1[i] * BASE1) % MOD1;
            pow2[i + 1] = (pow2[i] * BASE2) % MOD2;
        }

        int low = 1;
        int high = n;
        int ans = n;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (check(mid, pref1, pref2, pow1, pow2, n)) {

                ans = mid;
                high = mid - 1;

            } else {

                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean check(
        int len,
        long[] pref1,
        long[] pref2,
        long[] pow1,
        long[] pow2,
        int n
    ) {

        HashMap<Long, Integer> map = new HashMap<>();

        for (int i = 0; i + len <= n; i++) {

            int j = i + len;

            long h1 = (
                pref1[j] - pref1[i] * pow1[len] % MOD1 + MOD1
            ) % MOD1;

            long h2 = (
                pref2[j] - pref2[i] * pow2[len] % MOD2 + MOD2
            ) % MOD2;

            long hash = h1 * MOD2 + h2;

            map.put(hash, map.getOrDefault(hash, 0) + 1);
        }

        for (int freq : map.values()) {

            if (freq == 1) {
                return true;
            }
        }

        return false;
    }
}
