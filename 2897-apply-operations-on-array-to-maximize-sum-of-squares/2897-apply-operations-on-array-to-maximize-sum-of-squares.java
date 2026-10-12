class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] bitWise = new int[32];
        int MOD = 1_000_000_007;

        for(int num : nums){
            for(int bit = 0 ; bit < 32 ; bit++){
                if((num & (1 << bit)) != 0)
                    bitWise[bit]++;
            }
        }

        long answer = 0;

        for(int i = 0 ; i < k ; i++){
            long current = 0;

            for(int bit = 0 ; bit < 32 ; bit++){
                if(bitWise[bit] > 0){
                    current |= (1L << bit);
                    bitWise[bit]--;
                }
            }

            answer = (answer + current * current) % MOD;
        }

        return (int) answer;
    }
}