class Solution {
    public String convert(String s, int numRows) {
        int len = s.length();

        if(len == 1 || len <= numRows || numRows == 1) return s;

        StringBuilder[] row = new StringBuilder[numRows];

        for(int i = 0 ; i < numRows ; i++ ) row[i] = new StringBuilder();

        int currRow = 0;
        boolean downMove = false;

        for(char ch : s.toCharArray()){
            row[currRow].append(ch);

            if(currRow == 0 || currRow == numRows - 1) downMove = !downMove;

            currRow += downMove ? 1 : -1;
        }

        StringBuilder ans = new StringBuilder();

        for(StringBuilder sb : row){
            ans.append(sb);
        }

        return ans.toString();
    }
}