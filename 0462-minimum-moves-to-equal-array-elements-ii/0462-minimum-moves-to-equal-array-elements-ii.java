class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;

        int mid = nums[len / 2];

        int oper = 0;

        for(int x : nums) oper += Math.abs(mid - x);

        return oper;
    }
}