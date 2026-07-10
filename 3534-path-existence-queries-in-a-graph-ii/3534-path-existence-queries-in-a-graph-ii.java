class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        Integer[] ord = new Integer[n];
        for (int i = 0; i < n; i++) ord[i] = i;

        Arrays.sort(ord, (a, b) -> Integer.compare(nums[a], nums[b]));

        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[ord[i]] = i;
        }

        int[] comp = new int[n];
        int cid = 0;
        comp[0] = 0;

        for (int i = 1; i < n; i++) {
            if (nums[ord[i]] - nums[ord[i - 1]] > maxDiff)
                cid++;
            comp[i] = cid;
        }

        int[] far = new int[n];
        int r = 0;

        for (int l = 0; l < n; l++) {
            while (r + 1 < n &&
                   nums[ord[r + 1]] - nums[ord[l]] <= maxDiff) {
                r++;
            }
            far[l] = r;
        }

        int LOG = 17;
        while ((1 << LOG) <= n) LOG++;

        int[][] up = new int[LOG][n];

        for (int i = 0; i < n; i++) {
            up[0][i] = far[i];
        }

        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                up[k][i] = up[k - 1][up[k - 1][i]];
            }
        }

        int[] ans = new int[queries.length];

        for (int qi = 0; qi < queries.length; qi++) {

            int u = pos[queries[qi][0]];
            int v = pos[queries[qi][1]];

            if (u > v) {
                int tmp = u;
                u = v;
                v = tmp;
            }

            if (u == v) {
                ans[qi] = 0;
                continue;
            }

            if (comp[u] != comp[v]) {
                ans[qi] = -1;
                continue;
            }

            int cur = u;
            int dist = 0;

            for (int k = LOG - 1; k >= 0; k--) {
                if (up[k][cur] < v) {
                    cur = up[k][cur];
                    dist += (1 << k);
                }
            }

            ans[qi] = dist + 1;
        }

        return ans;
    }
}