class Solution {
    public boolean checkDivisibility(int n) {
        int x = n;

        int sum = 0 , product = 1;

        while(x != 0){
            int rem = x % 10;
            sum += rem;
            product *= rem;
            x /= 10;
        }

        return  n % (sum + product) == 0;
    }
}