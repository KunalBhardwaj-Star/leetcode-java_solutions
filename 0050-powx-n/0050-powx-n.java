class Solution {
    public double myPow(double x, int n) {
        if(n == 0)
            return 1;

        long N = n;
        if(n < 0){
            x = 1/x;
            N = -n;
        }

        return pow(x , N);
    }

    private double pow(double x , long N){
        if(N == 0)
            return 1;

        double half = pow(x , N / 2);

        return N % 2 == 0 ? half * half : half * half * x;
    }
}