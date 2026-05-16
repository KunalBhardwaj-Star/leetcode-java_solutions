class Solution {
    private boolean isPall(String c){
        int l = 0 , r = c.length() - 1;

        while(l < r){
            if(c.charAt(l) != c.charAt(r))
                return false;
            
            l++;
            r--;
        }

        return true;
    }
    public String longestPalindrome(String s) {
        int len = s.length();

        if(len == 1 || len == 0) 
            return s;

        String sub = "" + s.charAt(0);

        for(int i = 0 ; i < len ; i++){
            for(int j = i + 1; j < len ; j++){
                String curr = s.substring(i , j+1);
                if(isPall(curr))
                    sub = curr.length() > sub.length() ? curr : sub;
            }
        }

        return sub;
    }
}