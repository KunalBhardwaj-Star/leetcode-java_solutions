class Solution {
    public int reverse(int x) {
        boolean neg = x < 0 ? true : false;

        x = Math.abs(x);

        int ans = 0;

        while(x != 0){
            int rem = x % 10;

            if(ans > Integer.MAX_VALUE / 10  || (ans == Integer.MAX_VALUE / 10 && rem > 7))
                return 0;

            if(ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && rem < -8))
                return 0;

            ans *= 10;
            ans += rem;
            x /= 10;
        }

        return neg ? -ans : ans;
    }
}