import java.util.*;

class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] suf = new int[m];
        Arrays.fill(suf, -1);

        int p = n - 1;

        for (int j = m - 1; j >= 0; j--) {
            while (p >= 0 && word1.charAt(p) != word2.charAt(j)) {
                p--;
            }

            if (p >= 0) {
                suf[j] = p;
                p--;
            }
        }

        int[] ans = new int[m];
        int i = 0;
        boolean usedMismatch = false;

        for (int j = 0; j < m; j++) {

            while (i < n) {

                if (word1.charAt(i) == word2.charAt(j)) {
                    ans[j] = i;
                    i++;
                    break;
                }

                boolean canUseMismatch =
                        !usedMismatch &&
                        (
                            j == m - 1 ||
                            (suf[j + 1] != -1 && i < suf[j + 1])
                        );

                if (canUseMismatch) {
                    usedMismatch = true;
                    ans[j] = i;
                    i++;
                    break;
                }

                i++;
            }

            if (i > n && j < m - 1) {
                return new int[0];
            }

            if (ans[j] == 0 && (j > 0 || (m > 0 && ans[0] != 0))) {
            }
        }

        int prev = -1;
        for (int idx : ans) {
            if (idx <= prev) {
                return new int[0];
            }
            prev = idx;
        }

        return ans;
    }
}