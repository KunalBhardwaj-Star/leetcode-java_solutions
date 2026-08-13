class Solution {

    class Node {
        int len;
        int pref;
        int suff;
        int best;

        char leftChar;
        char rightChar;
    }

    private Node[] seg;
    private char[] arr;

    private Node merge(Node left, Node right) {

        if (left == null) return right;
        if (right == null) return left;

        Node res = new Node();

        res.len = left.len + right.len;

        res.leftChar = left.leftChar;
        res.rightChar = right.rightChar;

        // Prefix
        res.pref = left.pref;

        if (left.pref == left.len &&
            left.rightChar == right.leftChar) {

            res.pref = left.len + right.pref;
        }

        // Suffix
        res.suff = right.suff;

        if (right.suff == right.len &&
            left.rightChar == right.leftChar) {

            res.suff = right.len + left.suff;
        }

        // Best
        res.best = Math.max(left.best, right.best);

        if (left.rightChar == right.leftChar) {
            res.best = Math.max(
                res.best,
                left.suff + right.pref
            );
        }

        return res;
    }

    private void build(int idx, int l, int r) {

        if (l == r) {

            seg[idx] = new Node();

            seg[idx].len = 1;
            seg[idx].pref = 1;
            seg[idx].suff = 1;
            seg[idx].best = 1;

            seg[idx].leftChar = arr[l];
            seg[idx].rightChar = arr[l];

            return;
        }

        int mid = (l + r) / 2;

        build(2 * idx, l, mid);
        build(2 * idx + 1, mid + 1, r);

        seg[idx] = merge(seg[2 * idx], seg[2 * idx + 1]);
    }

    private void update(int idx,
                        int l,
                        int r,
                        int pos,
                        char ch) {

        if (l == r) {

            arr[pos] = ch;

            seg[idx].leftChar = ch;
            seg[idx].rightChar = ch;

            return;
        }

        int mid = (l + r) / 2;

        if (pos <= mid) {
            update(2 * idx, l, mid, pos, ch);
        } else {
            update(2 * idx + 1, mid + 1, r, pos, ch);
        }

        seg[idx] = merge(seg[2 * idx], seg[2 * idx + 1]);
    }

    public int[] longestRepeating(
            String s,
            String queryCharacters,
            int[] queryIndices) {

        int n = s.length();

        arr = s.toCharArray();

        seg = new Node[4 * n];

        build(1, 0, n - 1);

        int q = queryIndices.length;

        int[] ans = new int[q];

        for (int i = 0; i < q; i++) {

            update(
                1,
                0,
                n - 1,
                queryIndices[i],
                queryCharacters.charAt(i)
            );

            ans[i] = seg[1].best;
        }

        return ans;
    }
}