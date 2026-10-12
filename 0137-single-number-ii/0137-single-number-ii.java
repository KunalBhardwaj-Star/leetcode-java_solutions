class Solution {
    public int singleNumber(int[] nums) {
        int[] bitCount = new int[32];

        for(int i = 0 ; i < nums.length ; i++){
            int current = nums[i];

            for(int bit = 0 ; bit < 32 ; bit++){
                if((current & 1) == 1)
                    bitCount[bit]++;

                current >>= 1;
            }
        }

        int ans = 0;

        for(int bit = 0 ; bit < 32 ; bit++){
            if(bitCount[bit] % 3 == 1){
                ans |= (1 << bit);
            }
        }

        return ans;
    }
}