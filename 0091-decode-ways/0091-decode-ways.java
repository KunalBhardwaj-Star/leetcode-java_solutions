class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        if(n == 0 || s.charAt(0) == '0')
            return 0;

        int prev2 = 1;
        int prev1 = 1;

        for(int i = 1 ; i < n ; i++){
            int curr = 0;

            if(s.charAt(i) >= '1' && s.charAt(i) <= '9')
                curr += prev1;

            int twoDig = Integer.parseInt(s.substring(i-1 , i+1));
            if(twoDig >= 10 && twoDig <= 26)
                curr += prev2;

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}