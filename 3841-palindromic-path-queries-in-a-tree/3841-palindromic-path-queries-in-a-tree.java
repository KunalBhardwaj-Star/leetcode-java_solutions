import java.util.*;

class Solution {

    private int LOG;
    private int[] tin, tout, depth, mask, baseRootMask;
    private int[][] up;
    private List<Integer>[] graph;
    private Fenwick bit;

    class Fenwick {
        int[] tree;

        Fenwick(int n) {
            tree = new int[n + 2];
        }

        void update(int index, int value) {
            while (index < tree.length) {
                tree[index] ^= value;
                index += index & -index;
            }
        }

        int query(int index) {
            int result = 0;

            while (index > 0) {
                result ^= tree[index];
                index -= index & -index;
            }

            return result;
        }

        void rangeUpdate(int left, int right, int value) {
            update(left, value);
            update(right + 1, value);
        }
    }

    public List<Boolean> palindromePath(int n, int[][] edges,
                                        String s, String[] queries) {

        LOG = 1;
        while ((1 << LOG) <= n) {
            LOG++;
        }

        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        tin = new int[n];
        tout = new int[n];
        depth = new int[n];
        mask = new int[n];
        baseRootMask = new int[n];
        up = new int[LOG][n];

        for (int i = 0; i < n; i++) {
            mask[i] = 1 << (s.charAt(i) - 'a');
        }

        buildEulerTourAndLCA(n);

        bit = new Fenwick(n + 1);

        List<Boolean> answer = new ArrayList<>();

        for (String query : queries) {

            String[] parts = query.split(" ");

            if (parts[0].equals("update")) {

                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);

                int newMask = 1 << (c - 'a');
                int delta = mask[u] ^ newMask;

                if (delta != 0) {
                    bit.rangeUpdate(
                        tin[u] + 1,
                        tout[u] + 1,
                        delta
                    );

                    mask[u] = newMask;
                }

            } else {

                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int rootU = baseRootMask[u]
                          ^ bit.query(tin[u] + 1);

                int rootV = baseRootMask[v]
                          ^ bit.query(tin[v] + 1);

                int lca = getLCA(u, v);

                int pathMask = rootU ^ rootV ^ mask[lca];

                answer.add(
                    (pathMask & (pathMask - 1)) == 0
                );
            }
        }

        return answer;
    }

    private void buildEulerTourAndLCA(int n) {

        int timer = 0;

        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        int[] stackNode = new int[n];
        int[] stackNext = new int[n];

        int top = 0;

        stackNode[0] = 0;
        stackNext[0] = 0;

        parent[0] = 0;
        baseRootMask[0] = mask[0];
        tin[0] = timer++;

        while (top >= 0) {

            int u = stackNode[top];

            if (stackNext[top] < graph[u].size()) {

                int v = graph[u].get(stackNext[top]++);

                if (v == parent[u]) {
                    continue;
                }

                parent[v] = u;
                depth[v] = depth[u] + 1;

                baseRootMask[v] = baseRootMask[u] ^ mask[v];

                up[0][v] = u;

                for (int j = 1; j < LOG; j++) {
                    up[j][v] = up[j - 1][up[j - 1][v]];
                }

                tin[v] = timer++;

                top++;
                stackNode[top] = v;
                stackNext[top] = 0;

            } else {

                tout[u] = timer - 1;
                top--;
            }
        }

        for (int j = 1; j < LOG; j++) {
            up[j][0] = 0;
        }
    }

    private int getLCA(int u, int v) {

        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int j = 0; j < LOG; j++) {
            if ((diff & (1 << j)) != 0) {
                u = up[j][u];
            }
        }

        if (u == v) {
            return u;
        }

        for (int j = LOG - 1; j >= 0; j--) {
            if (up[j][u] != up[j][v]) {
                u = up[j][u];
                v = up[j][v];
            }
        }

        return up[0][u];
    }
}