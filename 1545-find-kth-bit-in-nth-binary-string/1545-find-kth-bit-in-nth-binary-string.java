class Solution {
    private char invert(char c){
        return c == '1' ? '0' : '1';
    }
    public char findKthBit(int n, int k) {
        if (n == 1) return '0';
        int len = (1 << n) - 1;

        int mid = (len / 2) + 1;

        if(mid == k) return '1';
        else if(mid > k) return findKthBit(n - 1, k);
        else return invert( findKthBit(n-1, len - k + 1) );
    }
}