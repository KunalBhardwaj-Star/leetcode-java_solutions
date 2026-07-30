class Solution {
    public boolean isMatch(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();

        boolean[][] match = new boolean[len1 + 1][len2 + 1];

        //initialization
        match[0][0] = true;
        for(int i = 1 ; i <= len1 ; i++)
            match[i][0] = false;

        for(int j = 1 ; j <= len2 ; j++)
            match[0][j] = p.charAt(j-1) == '*' ? match[0][j-1] : false;

        for(int i = 1 ; i <= len1 ; i++){
            for(int j = 1 ; j <= len2 ; j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?')
                    match[i][j] = match[i-1][j-1];

                else if (p.charAt(j-1) == '*')
                    match[i][j] = match[i-1][j] || match[i][j-1];

                else 
                    match[i][j] = false;
            }
        }

        return match[len1][len2];
    }
}