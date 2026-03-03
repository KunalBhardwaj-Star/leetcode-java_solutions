class Solution {
    private String reverse(String Sn){
        int left = 0 , right = Sn.length() - 1;
        char[] ch = Sn.toCharArray();

        while(left < right){
            char c = ch[left];
            ch[left] = ch[right];
            ch[right] = c;
            left ++;
            right --;
        }

        return new String(ch);
    }

    private String invert(String Sn){
        int len = Sn.length();
        char[] ch = Sn.toCharArray();

        for(int i = 0 ; i < len ; i++){
            ch[i] = ch[i] == '0' ? '1' : '0';
        }

        return new String(ch);
    }

    // private String generateBit(int n){
    //     int bit = 0 , count = 0;
    //     n -= 1;
    //     while(n != 0){
    //         int rem = n % 2;
    //         bit += rem * Math.pow(10 , count);
    //         n /= 2;
    //         count++;
    //     }

    //     return "0" + Integer.toString(bit);
    // }

    public char findKthBit(int n, int k) {
        if(n == 1) return '0';

        String[] dp = new String[n+1];

        dp[1] = "0";

        for(int i = 2 ; i <= n ; i++){
            dp[i] = dp[i-1] + "1" + reverse(invert(dp[i-1]));
            // System.out.println(dp[i]);
        }

        // String bit = generateBit(n);
        // String finalStr = generateBit(n) + "1" + reverse(invert(bit));
        // System.out.println(finalStr);

        // return finalStr.charAt(k);
        return dp[n].charAt(k-1);
    }
}