class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();

        int lft = 0 , rght = n - 1;

        while(lft < rght){
            while(lft < rght && !Character.isLetterOrDigit(s.charAt(lft)))
                lft++;

            while(lft < rght && !Character.isLetterOrDigit(s.charAt(rght)))
                rght--;

            if(Character.toLowerCase(s.charAt(lft)) != Character.toLowerCase(s.charAt(rght)))
                return false;

            lft++;
            rght--;
        }

        return true;
    }
}