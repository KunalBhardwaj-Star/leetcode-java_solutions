class Solution {
    public String[] createGrid(int m, int n) {
        char[][] str = new char[m][n];

        for(int i = 0 ; i < m ; i++){
            Arrays.fill(str[i] , '#');
        }
        
        for(int i = 0 ; i < n ; i++){
            str[0][i] = '.';
        }

        for(int i = 0 ; i < m ; i++){
            str[i][n-1] = '.';
        }

        String[] ans = new String[m];

        for(int i = 0 ; i < m ; i++){
            char[] curr = str[i];

            StringBuilder sb = new StringBuilder(new String(curr));

            ans[i] = sb.toString();
        }

        return ans;
    }
}