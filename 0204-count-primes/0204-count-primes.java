class Solution {
    public int countPrimes(int n) {

        if(n == 0 || n == 1)
            return 0;

        int[] prime = new int[n];

        Arrays.fill(prime , 2);

        prime[0] = 0;
        prime[1] = 1;

        for(int i = 2 ; i * i <= n ; i++){
            int j = 2 * i;

            while(j < n){
                prime[j]++;
                j += i;
            }
        }

        int ans = 0;

        for(int x : prime){
            if(x == 2)
                ans++;
        }

        return ans;
    }
}