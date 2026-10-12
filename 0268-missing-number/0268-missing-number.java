class Solution {
    public int missingNumber(int[] nums) {
        int desiredXOR = 0;

        for(int i = 0 ; i <= nums.length ; i++){
            desiredXOR ^= i;
        }

        for(int x : nums){
            desiredXOR ^= x;
        }

        return desiredXOR;
    }
}