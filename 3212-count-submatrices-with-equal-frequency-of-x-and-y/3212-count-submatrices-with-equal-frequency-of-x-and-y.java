class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length, m = grid[0].length;

        int[][] balance = new int[n][m];
        int[][] xCount = new int[n][m];

        int val = grid[0][0] == 'X' ? 1 : grid[0][0] == 'Y' ? -1 : 0;
        balance[0][0] = val;
        xCount[0][0] = grid[0][0] == 'X' ? 1 : 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                if(i == 0 && j == 0) continue;

                val = grid[i][j] == 'X' ? 1 : grid[i][j] == 'Y' ? -1 : 0;
                int xVal = grid[i][j] == 'X' ? 1 : 0;

                if(i == 0){
                    balance[i][j] = balance[i][j-1] + val;
                    xCount[i][j] = xCount[i][j-1] + xVal;
                }
                else if(j == 0){
                    balance[i][j] = balance[i-1][j] + val;
                    xCount[i][j] = xCount[i-1][j] + xVal;
                }
                else{
                    balance[i][j] = balance[i-1][j] + balance[i][j-1] - balance[i-1][j-1] + val;
                    xCount[i][j] = xCount[i-1][j] + xCount[i][j-1] - xCount[i-1][j-1] + xVal;
                }
            }
        }

        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(balance[i][j] == 0 && xCount[i][j] > 0){
                    count++;
                }
            }
        }

        return count;
    }
}