class Solution {

    private boolean check(int l , int r , String s){
        while(l < r){
            if(s.charAt(l) != s.charAt(r))
                return false;

            l += 1;
            r -= 1;
        }

        return true;
    }

    public int maxPalindromes(String s, int k) {

        int n = s.length();

        int ans = 0 , start = 0;

        for(int r = k - 1; r < n ; r++){
            int l = r - k + 1;

            if (l >= start && check(l , r , s)){
                ans += 1;
                start = r + 1;
                continue;
            }

            l = r - k;

            if(l >= start && check(l , r , s)){
                ans += 1;
                start = r + 1;
            }
        }

        return ans;
    }
}