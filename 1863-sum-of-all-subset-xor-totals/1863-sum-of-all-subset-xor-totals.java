class Solution {
    public int subsetXORSum(int[] nums) {
        return backtrack(nums , 0 , 0);
    }

    private int backtrack(int[] nums , int index , int currSum){
        if(index == nums.length) return currSum;

        int include = backtrack(nums , index + 1 , currSum ^ nums[index]);

        int exclude = backtrack(nums , index + 1 , currSum);

        return include + exclude;
    }
}