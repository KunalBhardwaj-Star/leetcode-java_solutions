class Solution {
    
    private boolean canReach(int[][] dis , int mid){
        int n = dis.length;

        if(dis[0][0] < mid)
            return false;

        boolean[][] vis = new boolean[n][n];

        Queue<int[]> q = new LinkedList<>();

        int[][] dir = {
            {-1 , 0},
            {0 , -1},
            {1 , 0},
            {0 , 1}
        };

        q.offer(new int[] {0 , 0});
        vis[0][0] = true;

        while(!q.isEmpty()){
            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];

            if(r == n-1 && c == n-1)
                return true;

            for(int[] d : dir){
                int dr = r + d[0];
                int dc = c + d[1];

                if(dr < 0 || dc < 0 || dr >= n || dc >= n)
                    continue;                    

                if(vis[dr][dc])
                    continue;

                if(dis[dr][dc] < mid)
                    continue;

                vis[dr][dc] = true;

                q.offer(new int[]{dr , dc});
            }
        }

        return false;
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();

        int[][] distance = new int[n][n];

        for (int[] row : distance) 
            Arrays.fill(row, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();

        int[][] dir = {
            {-1 , 0},
            {0 , -1},
            {1 , 0},
            {0 , 1}
        };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    q.offer(new int[] { i, j });
                    distance[i][j] = 0;
                }
            }
        }

        while(!q.isEmpty()){
            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];

            for(int[] d : dir){
                int dr = r + d[0];
                int dc = c + d[1];

                if(dr < 0 || dc < 0 || dr >= n || dc >= n)
                    continue;

                if(distance[dr][dc] != Integer.MAX_VALUE)
                    continue;

                distance[dr][dc] = distance[r][c] + 1;

                q.offer(new int[] {dr , dc});
            }
        }

        int low = 0 ;
        int high = 2 * n;
        int ans = 0 ;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(canReach(distance , mid)){
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return ans;
    }
}