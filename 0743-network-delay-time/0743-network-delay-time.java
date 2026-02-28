class Solution {
    public class Node implements Comparable<Node>{
        int src , weig;
        Node(int s , int w){
            this.src = s;
            this.weig = w;
        }

        @Override
        public int compareTo(Node x){
            return this.weig - x.weig;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<int[]>[] g = new ArrayList[n+1];

        for(int i = 0 ; i <= n ; i++) g[i] = new ArrayList<int[]>();

        for(int[] neigh : times){
            int src = neigh[0] , des = neigh[1] , w = neigh[2];

            int[] x = {des , w};

            g[src].add(x);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        int[] dist = new int[n+1];
        boolean[] vis = new boolean[n+1];

        for(int i = 0 ; i <= n ; i++) dist[i] = i == k ? 0 : Integer.MAX_VALUE;

        Node start = new Node(k , 0);
        pq.add(start);

        while(!pq.isEmpty()){
            Node curr = pq.remove();
            int u = curr.src;
            vis[u] = true;

            for(int[] neigh : g[u]){
                int v = neigh[0] , dt = neigh[1];

                if(dist[u] + dt < dist[v]){
                    dist[v] = dist[u] + dt;

                    Node next = new Node(v , dist[v]);
                    pq.add(next);
                }
            }
        }

        int delay = 0;

        for(int i = 1 ; i <= n ; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            delay = Math.max(delay , dist[i]);
        }

        return delay;
    }
}