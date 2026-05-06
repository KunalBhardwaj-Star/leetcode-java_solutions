class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int n = boxGrid.length , m = boxGrid[0].length;
        for(int i = 0 ; i < n ; i++){
            int pos = m - 1;
            for(int j = m - 1; j >= 0 ; j--){
                if(boxGrid[i][j] == '*') pos = j - 1;
                else if(boxGrid[i][j] == '#'){
                    boxGrid[i][pos] = '#';
                    
                    if(pos != j) boxGrid[i][j] = '.';

                    pos--;
                }
            }
        }

        char[][] res = new char[m][n];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                res[j][n - 1 - i] = boxGrid[i][j];
            }
        }

        return res;
    }
}