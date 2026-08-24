class Solution {
    public int myAtoi(String s) {
        s = s.trim();

        if(s.length() == 0)
            return 0;

        boolean neg = s.charAt(0) == '-' ? true : false;

        if(s.charAt(0) == '-' || s.charAt(0) == '+')
            s = s.substring(1 , s.length());

        int ans = 0;

        for(char ch : s.toCharArray()){
            if(ch < '0' || ch > '9')
                break;

            if(ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && ch > '7'))
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            ans *= 10;
            ans += (ch - '0');
        }

        return neg ? -ans : ans;
    }
}