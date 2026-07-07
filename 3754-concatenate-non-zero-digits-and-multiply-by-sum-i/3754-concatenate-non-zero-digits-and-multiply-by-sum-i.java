class Solution {
    public long sumAndMultiply(int n) {
        long sum = 0;
        long x = 0;

        int i =  0;

        while(n != 0){
            int curr = n % 10;

            if(curr != 0){
                x += (curr * Math.pow(10 , i));
                i++;
            }

            sum += curr;
            n /= 10;
        }

        return x * sum;
    }
}