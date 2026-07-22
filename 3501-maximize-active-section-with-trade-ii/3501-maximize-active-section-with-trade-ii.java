import java.util.*;

class Solution {
    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();
        List<Integer> rs = new ArrayList<>(), re = new ArrayList<>(), rt = new ArrayList<>();

        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) j++;
            rs.add(i); re.add(j - 1); rt.add(s.charAt(i) == '1' ? 1 : 0);
            i = j;
        }

        int m = rs.size();
        int[] runStart = new int[m], runEnd = new int[m], runType = new int[m], runLen = new int[m];
        for (int k = 0; k < m; k++) {
            runStart[k] = rs.get(k); runEnd[k] = re.get(k); runType[k] = rt.get(k);
            runLen[k] = runEnd[k] - runStart[k] + 1;
        }

        int[] posToRun = new int[n];
        for (int k = 0; k < m; k++)
            for (int p = runStart[k]; p <= runEnd[k]; p++) posToRun[p] = k;

        int totalOnes = 0;
        for (int idx = 0; idx < n; idx++) if (s.charAt(idx) == '1') totalOnes++;

        final int NEG = -1;
        int[] val = new int[m];
        Arrays.fill(val, NEG);
        for (int k = 1; k < m - 1; k++)
            if (runType[k] == 1) val[k] = runLen[k - 1] + runLen[k + 1];

        // sparse table for O(1) range-max queries
        int LOG = 1;
        while ((1 << LOG) <= m) LOG++;
        int[][] sparse = new int[LOG][];
        sparse[0] = val;
        for (int k = 1; (1 << k) <= m; k++) {
            int half = 1 << (k - 1), length = 1 << k, size = m - length + 1;
            int[] cur = new int[size], prev = sparse[k - 1];
            for (int idx = 0; idx < size; idx++) cur[idx] = Math.max(prev[idx], prev[idx + half]);
            sparse[k] = cur;
        }

        List<Integer> ans = new ArrayList<>(queries.length);
        for (int[] query : queries) {
            int l = query[0], r = query[1];
            int fL = posToRun[l], fR = posToRun[r];
            int best = 0;

            if (fR - fL >= 2) {
                int low = fL + 1, high = fR - 1;
                if (low == high) {
                    if (runType[low] == 1)
                        best = Math.max(best, (runEnd[fL] - l + 1) + (r - runStart[fR] + 1));
                } else {
                    if (runType[low] == 1)
                        best = Math.max(best, (runEnd[fL] - l + 1) + runLen[low + 1]);
                    if (runType[high] == 1)
                        best = Math.max(best, runLen[high - 1] + (r - runStart[fR] + 1));
                    if (high - 1 >= low + 1)
                        best = Math.max(best, rangeMax(sparse, low + 1, high - 1, NEG));
                }
            }
            ans.add(totalOnes + best);
        }
        return ans;
    }

    private int rangeMax(int[][] sparse, int l, int r, int NEG) {
        if (l > r) return NEG;
        int length = r - l + 1;
        int k = 31 - Integer.numberOfLeadingZeros(length);
        int[] level = sparse[k];
        return Math.max(level[l], level[r - (1 << k) + 1]);
    }
}