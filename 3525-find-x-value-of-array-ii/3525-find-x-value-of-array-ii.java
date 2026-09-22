class Solution {

    int k;

    class Node {
        int[] trans;
        int[][] cnt;

        Node() {
            trans = new int[k];
            cnt = new int[k][k];
        }
    }

    Node[] seg;

    private Node makeLeaf(int val) {
        Node res = new Node();

        int mod = val % k;

        for (int s = 0; s < k; s++) {
            int ns = (s * mod) % k;
            res.trans[s] = ns;
            res.cnt[s][ns] = 1;
        }

        return res;
    }

    private Node merge(Node left, Node right) {
        Node res = new Node();

        for (int s = 0; s < k; s++) {

            res.trans[s] = right.trans[left.trans[s]];

            for (int r = 0; r < k; r++) {
                res.cnt[s][r] =
                        left.cnt[s][r]
                      + right.cnt[left.trans[s]][r];
            }
        }

        return res;
    }

    private void build(int idx, int l, int r, int[] nums) {

        if (l == r) {
            seg[idx] = makeLeaf(nums[l]);
            return;
        }

        int mid = (l + r) >> 1;

        build(idx << 1, l, mid, nums);
        build(idx << 1 | 1, mid + 1, r, nums);

        seg[idx] = merge(seg[idx << 1], seg[idx << 1 | 1]);
    }

    private void update(int idx, int l, int r, int pos, int val) {

        if (l == r) {
            seg[idx] = makeLeaf(val);
            return;
        }

        int mid = (l + r) >> 1;

        if (pos <= mid) {
            update(idx << 1, l, mid, pos, val);
        } else {
            update(idx << 1 | 1, mid + 1, r, pos, val);
        }

        seg[idx] = merge(seg[idx << 1], seg[idx << 1 | 1]);
    }

    private Node query(int idx, int l, int r, int ql, int qr) {

        if (ql == l && qr == r) {
            return seg[idx];
        }

        int mid = (l + r) >> 1;

        if (qr <= mid) {
            return query(idx << 1, l, mid, ql, qr);
        }

        if (ql > mid) {
            return query(idx << 1 | 1, mid + 1, r, ql, qr);
        }

        Node left = query(idx << 1, l, mid, ql, mid);
        Node right = query(idx << 1 | 1, mid + 1, r, mid + 1, qr);

        return merge(left, right);
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {

        this.k = k;

        int n = nums.length;

        seg = new Node[4 * n + 5];

        build(1, 0, n - 1, nums);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            update(1, 0, n - 1, index, value);

            Node res = query(1, 0, n - 1, start, n - 1);

            ans[i] = res.cnt[1 % k][x];
        }

        return ans;
    }
}