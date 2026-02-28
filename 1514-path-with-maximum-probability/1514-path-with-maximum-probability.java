class Solution {
    public class Node implements Comparable<Node>{
        double src;
        double dis;
        Node(double s , double d){
            this.src = s;
            this.dis = d;
        }

        @Override
        public int compareTo(Node n){
            return Double.compare(n.dis, this.dis);
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<double[]>[] g = new ArrayList[n+1];
        for(int i = 0 ; i < n ; i++)g[i] = new ArrayList<double[]>();

        for(int i = 0 ; i < edges.length ; i++){
            int src = edges[i][0] , des = edges[i][1];
            double prob = succProb[i];

            g[src].add(new double[]{(double)des, prob});
            g[des].add(new double[]{(double)src, prob});
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();    
        pq.add(new Node((double)start_node , 1.0));

        double[] dist = new double[n];
        boolean[] vis = new boolean[n];

        Arrays.fill(dist , 0.0);
        dist[start_node] = 1.0;

        while(!pq.isEmpty()){
            Node curr = pq.remove();
            int u = (int)curr.src;
            if(vis[u]) continue;
            vis[u] = true;

            for(double[] neigh : g[u]){
                int v = (int)neigh[0];
                double w = neigh[1];

                if(dist[u] * w > dist[v]){
                    dist[v] = dist[u] * w;
                    pq.add(new Node((double)v , dist[v]));
                }
            }
        }

        return dist[end_node];
    }
}