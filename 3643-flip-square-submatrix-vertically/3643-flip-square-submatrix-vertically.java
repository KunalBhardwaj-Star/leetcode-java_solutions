class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int top = x;
        int bottom = x + k - 1;

        while (top < bottom) { 
            for (int j = 0; j < k; j++) {
                int currentCol = y + j;
                
                int temp = grid[top][currentCol];
                grid[top][currentCol] = grid[bottom][currentCol];
                grid[bottom][currentCol] = temp;
            }
            
            top++;    
            bottom--; 
        }

        return grid;
    }
}