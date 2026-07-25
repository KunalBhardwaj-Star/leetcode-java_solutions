class Solution {
    public int maxProduct(int n) {
        int len = (int)Math.log10(n) + 1;

        int[] sep = new int[len];

        int idx = 0;

        while(n != 0 && idx < len){
            sep[idx++] = n % 10;

            n /= 10;
        }

        Arrays.sort(sep);

        return sep[len - 1] * sep[len - 2];
    }
}