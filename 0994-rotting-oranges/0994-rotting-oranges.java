class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length , cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0  , minutes = 0;
        int[][] dir = {{0 , 1} , {1 , 0} , {0 , -1} , {-1 , 0}};

        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                if(grid[i][j] == 2) queue.add(new int[]{i , j});
                else if(grid[i][j] == 1) freshCount++;
            }
        }

        if(freshCount == 0) return 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            boolean minInc = false;

            for(int i = 0 ; i < size ; i++){
                int[] curr = queue.poll();

                for(int[] x : dir){
                    int nr = curr[0] + x[0] , nc = curr[1] + x[1];

                    if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        queue.add(new int[]{nr , nc});
                        freshCount--;
                        minInc = true;
                    }
                }
            }

            if(minInc) minutes++;
        }

        return freshCount == 0 ? minutes : -1;

    }
}