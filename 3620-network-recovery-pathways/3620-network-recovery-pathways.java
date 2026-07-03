import java.util.*;

class Solution {

    List<int[]>[] graph;
    List<Integer> topo = new ArrayList<>();

    private boolean check(long minEdge, long k, boolean[] online) {

        int n = graph.length;
        long INF = Long.MAX_VALUE / 2;

        long[] dp = new long[n];
        Arrays.fill(dp, INF);

        dp[0] = 0;

        for (int u : topo) {

            if (dp[u] == INF)
                continue;

            if (u != 0 && u != n - 1 && !online[u])
                continue;

            for (int[] edge : graph[u]) {

                int v = edge[0];
                int w = edge[1];

                if (w < minEdge)
                    continue;

                if (v != n - 1 && !online[v])
                    continue;

                dp[v] = Math.min(dp[v], dp[u] + w);
            }
        }

        return dp[n - 1] <= k;
    }

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {

        int n = online.length;

        graph = new ArrayList[n];
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        int maxWeight = 0;

        for (int[] e : edges) {

            int u = e[0];
            int v = e[1];
            int w = e[2];

            graph[u].add(new int[]{v, w});
            indegree[v]++;

            maxWeight = Math.max(maxWeight, w);
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }

        while (!q.isEmpty()) {

            int u = q.poll();
            topo.add(u);

            for (int[] edge : graph[u]) {

                int v = edge[0];

                indegree[v]--;

                if (indegree[v] == 0)
                    q.offer(v);
            }
        }

        int left = 0;
        int right = maxWeight;
        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (check(mid, k, online)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}