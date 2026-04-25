class Solution {
    private int rev(int n){
        int reverse = 0;

        while(n != 0){
            reverse = reverse * 10 + (n % 10);
            n /= 10;
        }

        return reverse;
    }
    public int mirrorDistance(int n) {
        int rev_n = rev(n);
        return Math.abs(rev_n - n);
    }
}