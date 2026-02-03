class Solution {
    public int subtractProductAndSum(int n) {
        int product = 1 , sum = 0;

        while(n != 0){
            int p = n % 10;
            n /= 10;
            product *= p;
            sum += p;
        }

        return (product - sum);
    }
}