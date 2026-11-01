class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;

        for(int x : nums){
            min = Math.min(min , x);
        }

        int ans = 0;

        for(int x : nums){
            ans += (x - min);
        }

        return ans;
    }
}