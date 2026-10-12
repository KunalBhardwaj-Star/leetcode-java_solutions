class Solution {
    public int[] countBits(int n) {
        int[] bitCount = new int[n+1];

        for(int i = 1 ; i <= n ; i++){
            bitCount[i] = bitCount[i >> 1] + (i & 1);
        }

        return bitCount;
    }
}