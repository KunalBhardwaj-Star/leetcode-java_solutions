class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int len = encodedText.length();
        int cols = (len + 1) / rows;
        char[][] mat = new char[rows][cols];

        int ch = 0 , i = 0 , j = 0;

        while(i < rows && ch < len){
            char curr = encodedText.charAt(ch);
            if(j == cols){
                i++;
                j = 0;
            }
            mat[i][j] = curr;
            j++;
            ch++;
        }

        // for(int k = 0 ; k < rows ; k++){
        //     for(int l = 0 ; l < cols ; l++){
        //         System.out.print(k + " " + l + " " + mat[k][l] + " ");
        //     }
        //     System.out.println();
        // }

        StringBuilder sb = new StringBuilder();

        int count = 0;

        while(count < cols){
            int r = 0 , c = count; 
            while(r < rows && c < cols){
                sb.append(mat[r][c]);
                r++;
                c++;
            }
            count++;
        }

        String s = sb.toString();

        System.out.println(s + " cols " + cols );

        int end = s.length()-1;

        //if(s.charAt(end) != ' ') return s;

        while(end >= 0 && (s.charAt(end) == ' ' || s.charAt(end) == '\u0000')) end --;

        return s.substring(0 , end+1);
    }
}