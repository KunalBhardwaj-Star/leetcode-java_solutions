class Solution {
    public int[] decode(int[] encoded) {
        int len = encoded.length;

        int[] ans = new int[len + 1];

        int x = 0;

        for(int i = 1 ; i <= len + 1; i++)
            x ^= i;

        ans[0] ^= x;

        for(int i = 1 ; i < len ; i += 2)
            ans[0] ^= encoded[i];

        for(int i = 1 ; i <= len ; i++){
            ans[i] = encoded[i-1] ^ ans[i-1];
        }

        return ans;
    }
}