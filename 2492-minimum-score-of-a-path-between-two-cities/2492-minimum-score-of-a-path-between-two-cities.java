class Solution {
    int ans = Integer.MAX_VALUE;
    public int minScore(int n, int[][] roads) {
        int m = roads.length;

        List<int[]>[] graph = new ArrayList[n+1];

        for(int i = 0 ; i <= n ; i++)
            graph[i] = new ArrayList<>();

        for(int[] road : roads){
            graph[road[0]].add(new int[] {road[1] , road[2]});
            graph[road[1]].add(new int[] {road[0] , road[2]});
        }

        boolean[] vis = new boolean[n+1];

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        vis[1] = true;

        while(!q.isEmpty()){
            int x = q.poll();

            for(int[] curr : graph[x]){
                ans = Math.min(ans , curr[1]);

                if(!vis[curr[0]]){
                    vis[curr[0]] = true;
                    q.offer(curr[0]);
                }
            }
        }

        return ans;
    }
}