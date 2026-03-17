class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int row = matrix.length , col = matrix[0].length;
        int maxArea = 0;

        for(int r = 1; r < row ; r++){
            for(int c = 0 ; c < col ; c++){
                if(matrix[r][c] == 1) matrix[r][c] += matrix[r-1][c];
            }
        }

        for(int[] curr : matrix){
            Arrays.sort(curr);
            for(int c = col - 1 ; c >= 0 ; c--){
                int height = curr[c];
                int width = col - c;

                maxArea = Math.max(maxArea , height * width);
            }
        }

        return maxArea;
    }
}