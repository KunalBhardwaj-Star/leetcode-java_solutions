import java.util.*;

class Solution {

    int[] seg;

    private void update(int node, int l, int r, int idx, int val) {
        if (l == r) {
            seg[node] = val;
            return;
        }

        int mid = (l + r) / 2;

        if (idx <= mid) {
            update(node * 2, l, mid, idx, val);
        } else {
            update(node * 2 + 1, mid + 1, r, idx, val);
        }

        seg[node] = Math.max(seg[node * 2], seg[node * 2 + 1]);
    }

    private int query(int node, int l, int r, int ql, int qr) {
        if (ql > r || qr < l) {
            return 0;
        }

        if (ql <= l && r <= qr) {
            return seg[node];
        }

        int mid = (l + r) / 2;

        return Math.max(
                query(node * 2, l, mid, ql, qr),
                query(node * 2 + 1, mid + 1, r, ql, qr)
        );
    }

    public List<Boolean> getResults(int[][] queries) {

        int mx = 0;

        for (int[] q : queries) {
            mx = Math.max(mx, q[1]);
        }

        mx++;

        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0);
        obstacles.add(mx);

        for (int[] q : queries) {
            if (q[0] == 1) {
                obstacles.add(q[1]);
            }
        }

        seg = new int[4 * (mx + 5)];

        Integer prev = null;

        for (Integer curr : obstacles) {
            if (prev != null) {
                update(1, 0, mx, curr, curr - prev);
            }
            prev = curr;
        }

        List<Boolean> ans = new ArrayList<>();

        for (int i = queries.length - 1; i >= 0; i--) {

            int[] q = queries[i];

            if (q[0] == 2) {

                int x = q[1];
                int sz = q[2];

                Integer rightObs = obstacles.higher(x);
                Integer leftObs = obstacles.lower(rightObs);

                int best = query(1, 0, mx, 0, leftObs);

                best = Math.max(best, x - leftObs);

                ans.add(best >= sz);

            } else {

                int p = q[1];

                Integer left = obstacles.lower(p);
                Integer right = obstacles.higher(p);

                update(1, 0, mx, right, right - left);

                obstacles.remove(p);
            }
        }

        Collections.reverse(ans);

        return ans;
    }
}