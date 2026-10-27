class Solution {

    private boolean isPallindrome(String s){
        int l = 0 , r = s.length() - 1;

        while(l < r){
            if(s.charAt(l) != s.charAt(r))
                return false;

            l++;
            r--;
        }

        return true;
    }

    public int countSubstrings(String s) {
        int n = s.length();

        int count = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = i; j < n ; j++){
                if(isPallindrome(s.substring(i , j + 1)))
                    count++;
            }
        }

        return count;
    }
}