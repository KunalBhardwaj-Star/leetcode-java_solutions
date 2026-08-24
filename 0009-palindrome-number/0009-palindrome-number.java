class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;

        String num = "" + x;

        int l = 0 , r = num.length() - 1;

        while(l < r){
            if(num.charAt(l) != num.charAt(r))
                return false;

            l++;
            r--;
        }

        return true;

    }
}