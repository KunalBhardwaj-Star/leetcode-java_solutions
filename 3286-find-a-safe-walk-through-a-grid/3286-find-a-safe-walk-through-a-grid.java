class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();

        int[][] dis = new int[n][m];

        int INF = Integer.MAX_VALUE;
        
        for(int[] d : dis)
            Arrays.fill(d , INF);

        dis[0][0] = grid.get(0).get(0);

        Deque<int[]> dq = new ArrayDeque<>();
        dq.offerFirst(new int[] {0 , 0});

        int[][] dir = {
                {-1 , 0},
                {0 , -1},
                {1 , 0},
                {0 , 1}
            };

        while(!dq.isEmpty()){
            int[] curr = dq.pollFirst();
            int r = curr[0];
            int c = curr[1];

            for(int[] d : dir){
                int dr = r + d[0];
                int dc = c + d[1];

                if(dr < 0 || dc < 0 || dr >= n || dc >= m)
                    continue;

                int cost = grid.get(dr).get(dc);

                if(cost + dis[r][c] < dis[dr][dc]){
                    dis[dr][dc] = cost + dis[r][c];

                    if(cost == 0)
                        dq.offerFirst(new int[] {dr , dc});

                    else 
                        dq.offerLast(new int[] {dr , dc});
                }
            }
        }

        return dis[n-1][m-1] < health;
    }
}