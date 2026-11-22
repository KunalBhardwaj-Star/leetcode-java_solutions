class Solution {
    public boolean checkString(String s) {
        boolean a = s.charAt(0) == 'a';
        boolean b = s.charAt(0) == 'b';

        for(int i = 1; i < s.length() ; i++){
            char ch = s.charAt(i);

            if(ch == 'a' && b)
                return false;

            if(ch == 'b')
                b = true;
        }

        return true;
    }
}