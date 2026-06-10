import java.util.*;

class Solution {
    static class Node {
        long val;
        int l, r;

        Node(long val, int l, int r) {
            this.val = val;
            this.l = l;
            this.r = r;
        }
    }

    int[][] mx;
    int[][] mn;
    int[] lg;

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;

        buildSparse(nums);

        PriorityQueue<Node> pq =
                new PriorityQueue<>((a, b) -> Long.compare(b.val, a.val));

        for (int l = 0; l < n; l++) {
            long v = getValue(l, n - 1);
            pq.offer(new Node(v, l, n - 1));
        }

        long ans = 0;

        while (k-- > 0) {
            Node cur = pq.poll();

            ans += cur.val;

            if (cur.r > cur.l) {
                int nr = cur.r - 1;
                pq.offer(new Node(
                        getValue(cur.l, nr),
                        cur.l,
                        nr
                ));
            }
        }

        return ans;
    }

    private void buildSparse(int[] nums) {
        int n = nums.length;

        lg = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            lg[i] = lg[i / 2] + 1;
        }

        int K = lg[n] + 1;

        mx = new int[K][n];
        mn = new int[K][n];

        for (int i = 0; i < n; i++) {
            mx[0][i] = nums[i];
            mn[0][i] = nums[i];
        }

        for (int j = 1; j < K; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                mx[j][i] = Math.max(
                        mx[j - 1][i],
                        mx[j - 1][i + (1 << (j - 1))]
                );

                mn[j][i] = Math.min(
                        mn[j - 1][i],
                        mn[j - 1][i + (1 << (j - 1))]
                );
            }
        }
    }

    private long getValue(int l, int r) {
        int len = r - l + 1;
        int j = lg[len];

        int maximum = Math.max(
                mx[j][l],
                mx[j][r - (1 << j) + 1]
        );

        int minimum = Math.min(
                mn[j][l],
                mn[j][r - (1 << j) + 1]
        );

        return (long) maximum - minimum;
    }
}