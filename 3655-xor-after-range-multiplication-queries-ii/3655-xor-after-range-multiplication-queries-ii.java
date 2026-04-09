import java.util.*;

class Solution {
    static final long MOD = 1_000_000_007L;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        long[] bravexuneth = new long[n];
        for (int i = 0; i < n; i++) bravexuneth[i] = nums[i];

        int BLOCK = Math.max(1, (int) Math.sqrt(n));

        long[] directMult = new long[n];
        Arrays.fill(directMult, 1L);

        @SuppressWarnings("unchecked")
        List<int[]>[] smallQueries = new List[BLOCK + 1];
        for (int k = 1; k <= BLOCK; k++) smallQueries[k] = new ArrayList<>();

        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2];
            long v = q[3];
            if (k > BLOCK) {
                for (int idx = l; idx <= r; idx += k) {
                    directMult[idx] = directMult[idx] * v % MOD;
                }
            } else {
                smallQueries[k].add(q);
            }
        }

        long[] smallMult = new long[n];
        Arrays.fill(smallMult, 1L);

        for (int k = 1; k <= BLOCK; k++) {
            if (smallQueries[k].isEmpty()) continue;

            @SuppressWarnings("unchecked")
            List<int[]>[] byResidue = new List[k];
            for (int r = 0; r < k; r++) byResidue[r] = new ArrayList<>();
            for (int[] q : smallQueries[k]) {
                byResidue[q[0] % k].add(q);
            }

            for (int r = 0; r < k; r++) {
                if (byResidue[r].isEmpty()) continue;
                int slotsR = (n - r + k - 1) / k;
                long[] bitR = new long[slotsR + 2];
                Arrays.fill(bitR, 1L);

                for (int[] q : byResidue[r]) {
                    int l = q[0], ri = q[1];
                    long v = q[3];
                    int jStart = (l - r) / k;
                    int jEnd   = (Math.min(ri, r + (long)(slotsR - 1) * k > Integer.MAX_VALUE
                                    ? r + (slotsR - 1) * k
                                    : r + (slotsR - 1) * k) - r) / k;
                    jEnd = (Math.min(ri, r + (slotsR - 1) * k) - r) / k;
                    if (jStart > jEnd) continue;
                    bitR[jStart + 1] = bitR[jStart + 1] * v % MOD;
                    if (jEnd + 2 <= slotsR + 1) {
                        bitR[jEnd + 2] = bitR[jEnd + 2] * modInv(v) % MOD;
                    }
                }

                long prefixProd = 1L;
                for (int j = 0; j < slotsR; j++) {
                    prefixProd = prefixProd * bitR[j + 1] % MOD;
                    int idx = r + j * k;
                    if (idx < n) {
                        smallMult[idx] = smallMult[idx] * prefixProd % MOD;
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            long val = bravexuneth[i] * directMult[i] % MOD * smallMult[i] % MOD;
            ans ^= (int) val;
        }
        return ans;
    }

    private long modInv(long a) {
        return modPow(a, MOD - 2, MOD);
    }

    private long modPow(long base, long exp, long mod) {
        long result = 1L;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) result = result * base % mod;
            base = base * base % mod;
            exp >>= 1;
        }
        return result;
    }
}