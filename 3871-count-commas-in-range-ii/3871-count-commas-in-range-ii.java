class Solution {
    public long countCommas(long n) {
        if (n < 1000)
            return 0;

        long ans = 0;

        while(n >= 1000){
            if(Math.pow(10 , 3) <= n && n < Math.pow(10 , 6)){
                ans += (n - 999);
                n = 999;
            }

            else if(Math.pow(10 , 6) <= n && n < Math.pow(10 , 9)){
                ans += (n - (long)Math.pow(10 , 6) + 1) * 2;
                n = (long)Math.pow(10 , 6) - 1;
            }
            else if(Math.pow(10 , 9) <= n && n < Math.pow(10 , 12)){
                ans += (n - (long)Math.pow(10 , 9) + 1) * 3;
                n = (long)Math.pow(10 , 9) - 1;
            } else if(Math.pow(10 , 12) <= n && n < Math.pow(10 , 15)){
                ans += (n - (long)Math.pow(10 , 12) + 1) * 4;
                n = (long)Math.pow(10 , 12) - 1;
            } else{
                ans += 5;
                n = (long)Math.pow(10 , 15) - 1;
            }
        }

        return ans;
    }
}