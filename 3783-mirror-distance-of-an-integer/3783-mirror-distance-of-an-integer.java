class Solution {
    private int reverse(int x) {
       int rev = 0;

       while(x != 0){
        int curr = x % 10;

        rev = rev * 10 + curr;

        x /= 10;
       }

       return rev;
    }

    public int mirrorDistance(int n) {
        int rev = reverse(n);

        return Math.abs(rev - n);
    }
}