import java.util.*;

class Solution {
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        Map<Integer, int[]> map = new HashMap<>();
        map.put(1, new int[]{2,3}); 
        map.put(2, new int[]{0,1}); 
        map.put(3, new int[]{2,1}); 
        map.put(4, new int[]{3,1}); 
        map.put(5, new int[]{2,0}); 
        map.put(6, new int[]{3,0}); 

        boolean[][] vis = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        vis[0][0] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            if(r == m-1 && c == n-1) return true;

            for(int d : map.get(grid[r][c])) {
                int nr = r + dirs[d][0];
                int nc = c + dirs[d][1];

                if(nr < 0 || nc < 0 || nr >= m || nc >= n || vis[nr][nc]) continue;

                for(int back : map.get(grid[nr][nc])) {
                    int rr = nr + dirs[back][0];
                    int cc = nc + dirs[back][1];

                    if(rr == r && cc == c) {
                        vis[nr][nc] = true;
                        q.add(new int[]{nr, nc});
                        break;
                    }
                }
            }
        }

        return false;
    }
}