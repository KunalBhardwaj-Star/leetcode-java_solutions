class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length())
            return false;
        
        String con = s + s;

        int len1 = con.length() , len2 = goal.length();

        for(int i = 0; i < len1 - len2 ; i++){
            String curr = con.substring(i , i + len2);

            if(goal.equals(curr)) return true;
        }

        return false;
    }
}