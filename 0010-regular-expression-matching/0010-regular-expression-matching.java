class Solution {
    private boolean match(int i , int j , String s , String p){
        if(j == p.length())
            return i == s.length();

        boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') ;

        if (j + 1 < p.length() && p.charAt(j+1) == '*')
            return match(i , j + 2 , s, p) || (firstMatch && match(i+1 , j , s , p));

        else 
            return firstMatch && match(i + 1 , j + 1 , s , p);
    }
    public boolean isMatch(String s, String p) {
        return match(0 , 0 , s , p);
    }
}