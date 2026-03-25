class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length , m = grid[0].length;
        int[] arr = new int[n * m];
        int MOD = 12345;

        for(int i = 0 ; i < n * m ; i++){
            arr[i] = grid[i/m][i%m] % MOD;
        }

        int[] prefix = new int[n * m];
        int[] suffix = new int[n * m];

        prefix[0] = 1;

        for(int i = 1 ; i < n * m ; i++){
            prefix[i] = (int)((long)prefix[i-1] * arr[i-1] % MOD) ;
        }

        suffix[n * m - 1] = 1;
        for(int i = n * m - 2 ; i >= 0 ; i--){
            suffix[i] = (int)((long)suffix[i+1] * arr[i+1] % MOD);
        }

        int[][] result = new int[n][m];

        for(int i = 0 ; i < n * m ; i++){
            result[i/m][i%m] = (int)((long)prefix[i] * suffix[i] % MOD);
        }

        return result;
    }
}