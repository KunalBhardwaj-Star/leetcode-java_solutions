import java.util.*;

class Solution {

    static final int MOD = 1_000_000_007;
    int LOG = 17;
    List<Integer>[] adj;
    int[][] parent;
    int[] depth;

    void dfs(int node, int par) {
        parent[node][0] = par;

        for (int nei : adj[node]) {
            if (nei == par) continue;
            depth[nei] = depth[node] + 1;
            dfs(nei, node);
        }
    }

    int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int tmp = u;
            u = v;
            v = tmp;
        }

        for (int i = LOG; i >= 0; i--) {
            if (parent[u][i] != -1 &&
                depth[parent[u][i]] >= depth[v]) {
                u = parent[u][i];
            }
        }

        if (u == v) return u;

        for (int i = LOG; i >= 0; i--) {
            if (parent[u][i] != parent[v][i]) {
                u = parent[u][i];
                v = parent[v][i];
            }
        }

        return parent[u][0];
    }

    long modPow(long base, int exp) {
        long res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1)
                res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {

        int n = edges.length + 1;

        adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            adj[i] = new ArrayList<>();

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        parent = new int[n + 1][LOG + 1];
        depth = new int[n + 1];

        for (int[] row : parent)
            Arrays.fill(row, -1);

        dfs(1, -1);

        for (int j = 1; j <= LOG; j++) {
            for (int i = 1; i <= n; i++) {
                if (parent[i][j - 1] != -1)
                    parent[i][j] = parent[parent[i][j - 1]][j - 1];
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int u = queries[i][0];
            int v = queries[i][1];

            if (u == v) {
                ans[i] = 0;
                continue;
            }

            int lca = lca(u, v);

            int dist = depth[u] + depth[v] - 2 * depth[lca];

            ans[i] = (int) modPow(2, dist - 1);
        }

        return ans;
    }
}