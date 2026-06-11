class Solution {
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        long mod = 1_000_000_000 + 7;

        ArrayList<Integer>[] adj = new ArrayList[n+1];

        for(int i = 1 ; i <= n ; i++)
            adj[i] = new ArrayList<>();

        for(int[] x : edges){
            int u = x[0] , v = x[1];

            adj[u].add(v);
            adj[v].add(u);
        }

        boolean[] vis = new boolean[n + 1];

        int[] depth = new int[n + 1];

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        vis[1] = true;

        int maxDepth = 0;

        while(!q.isEmpty()){
            int curr = q.poll();

            maxDepth = Math.max(maxDepth , depth[curr]);

            for(int neigh : adj[curr]){
                if(!vis[neigh]){
                    vis[neigh] = true;
                    depth[neigh] = depth[curr] + 1;
                    q.offer(neigh);
                }
            }
        }

        return (int)depMod(2 , maxDepth - 1 , mod);
    }

    private long depMod(long base , long exp , long mod){
        long ans = 1;

        while(exp > 0){
            if((exp & 1) == 1)
                ans = (ans * base) % mod;

            base = base * base % mod;
            exp >>= 1;
        }

        return ans;
    }
}