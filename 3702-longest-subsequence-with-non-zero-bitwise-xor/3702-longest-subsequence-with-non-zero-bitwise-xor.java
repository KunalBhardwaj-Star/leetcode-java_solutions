class Solution {
    public int longestSubsequence(int[] nums) {
        int len = nums.length;

        int totalXOR = 0 ;

        for(int num : nums){
            totalXOR ^= num;
        }

        if(totalXOR != 0)
            return len;

        for(int num : nums){
            if(num != 0)
                return len - 1;
        }

        return 0;
    }
}