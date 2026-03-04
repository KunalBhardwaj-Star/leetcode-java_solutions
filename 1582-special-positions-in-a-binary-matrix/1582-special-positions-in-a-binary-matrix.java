class Solution {
    public int numSpecial(int[][] mat) {
        int r = mat.length , c = mat[0].length;
        int[] row = new int[r];
        int[] col = new int[c];

        for(int i = 0 ; i < r ; i++){
            for(int j = 0 ; j < c ; j++){
                if(mat[i][j] == 1){
                    row[i] += 1;
                    col[j] += 1;
                }
            }
        }

        int specialCount = 0;

        for(int i = 0 ; i < r ; i++){
            for(int j = 0 ; j < c ; j++){
                if(mat[i][j] == 1 && row[i] == 1 && col[j] == 1 ) specialCount += 1;
            }
        }

        return specialCount;
    }
}