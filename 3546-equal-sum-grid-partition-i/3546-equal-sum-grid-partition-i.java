class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length , m = grid[0].length;

        long sum = 0;

        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < m ; j++){
                sum += grid[i][j];
            }
        }

        if(sum % 2 != 0) return false;

        // horizontal sum
        long uprSum = 0;
        for(int i = 0 ; i < n - 1; i++){
            for(int j = 0 ; j < m ; j++){
                uprSum += grid[i][j];
            }

            if(uprSum == sum - uprSum) return true;
        }

        //vertical
        long leftSum = 0;
        for(int i = 0 ; i < m - 1 ; i++){
            for(int j = 0 ; j < n ; j++){
                leftSum += grid[j][i];
            }

            if(leftSum == sum - leftSum) return true;
        }

        return false;
    }
}