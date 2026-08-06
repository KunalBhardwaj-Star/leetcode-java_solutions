class Solution {
    public int smallestNumber(int n, int t) {
        if(n % 10 == 0)
            return n;

        while(n <= 100){
            int low = n % 10 ,  hgh = (n / 10);

            if(((low * hgh) % t == 0 && hgh > 0) || low % t == 0)
                break;

            n++;
        }

        return n;
    }
}