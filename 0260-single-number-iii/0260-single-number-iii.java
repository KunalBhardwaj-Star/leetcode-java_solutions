class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums.length == 2)
            return nums;

        int xor = 0;

        for(int x : nums){
            xor ^= x;
        }

        int a = 0 , b = 0;

        int rightmostSetBit = xor & (-xor);

        for(int x : nums){
            if((x & rightmostSetBit) == 0)
                a ^= x;

            else
                b ^= x;
        }

        return new int[] {a , b};
    }
}