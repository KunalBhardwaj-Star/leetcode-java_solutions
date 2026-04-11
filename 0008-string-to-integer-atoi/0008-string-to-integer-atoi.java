class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        long num = 0;

        int len = s.length();

        if(len == 0) return 0;

        int i = 0;
        boolean neg = false;

        if(s.charAt(0) == '-' || s.charAt(0) == '+'){
            neg = s.charAt(0) == '-';
            i++;
        }

        while(i < len){
            char ch = s.charAt(i);

            if(ch < '0' || ch > '9') break;

            num = num * 10 + (ch - '0');

            if (!neg && num > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if (neg && -num < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        return neg ? -(int)num : (int)num;
    }
}