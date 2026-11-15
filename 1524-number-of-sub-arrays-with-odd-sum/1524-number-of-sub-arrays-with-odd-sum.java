class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1_000_000_007;
        int oddSum = 0;
        int evenSum = 1;
        int sum = 0;
        int count = 0;

        for(int x : arr){
            sum += x;

            if(sum % 2 == 0){
                count = (count + oddSum) % MOD;
                evenSum++;
            }

            else{
                count = (count + evenSum) % MOD;
                oddSum++;
            }

            oddSum %= MOD;
            evenSum %= MOD;
        }

        return count;
    }
}