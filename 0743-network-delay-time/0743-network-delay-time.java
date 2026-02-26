class Solution {
    public class Node implements Comparable<Node>{
        int src , dis;
        Node(int s , int dt){
            this.src = s;
            this.dis = dt;
        }

        @Override
        public int compareTo(Node other) {
            return this.dis - other.dis;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<int[]>[] g = new ArrayList[n+1];

        for(int i = 0 ; i <= n ; i++) g[i] = new ArrayList<int[]>();

        for(int i = 0 ; i < times.length; i++){
            int src = times[i][0] , des = times[i][1] , w = times[i][2];
            int[] x = {des , w};
            g[src].add(x);
        }

        int[] dist = new int[n+1];
        boolean[] vis = new boolean[n+1];

        for(int i = 1; i <= n ; i++) if(i != k) dist[i] = Integer.MAX_VALUE;

        PriorityQueue<Node> pq = new PriorityQueue<>();

        Node src = new Node(k , 0);
        pq.add(src);

        while(!pq.isEmpty()){
            Node curr = pq.remove();
            int u = curr.src;

            if(vis[u]) continue;
            else {
                vis[u] = true;
                for(int[] neigh : g[u]){
                int v = neigh[0] , w = neigh[1];
                if(dist[u] + w < dist[v]){
                    dist[v] = dist[u] + w;
                    Node inp = new Node(v , dist[v]);
                    pq.add(inp);
                }
              }
            }
        }

        int minTime = 0;
        for(int i = 1 ; i <= n ; i++){
            if(dist[i] == Integer.MAX_VALUE){
                System.out.println(i);
                return -1;
            }
            minTime = Math.max(dist[i] , minTime);
        }

        return minTime;
    }
}