class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int top = 0;
        int bottom = n-1;
        int lft = 0;
        int rght = n-1;

        int val = 0;

        while(top <= bottom && lft <= rght){
            for(int j = lft ; j <= rght ; j++){
                matrix[top][j] = ++val;
            }
            top++;

            for(int i = top ; i <= bottom ; i++){
                matrix[i][rght] = ++val;
            }
            rght--;

            if (top <= bottom) {
                for (int j = rght; j >= lft; j--) {
                    matrix[bottom][j] = ++val;
                }
                bottom--;
            }

            if (lft <= rght) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][lft] = ++val;
                }
                lft++;
            }
        }

        return matrix;
    }
}