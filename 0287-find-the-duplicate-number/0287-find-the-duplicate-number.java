class Solution {
    public int findDuplicate(int[] nums) {
        boolean[] vis = new boolean[nums.length + 1];

        for(int x : nums){
            if(vis[x])
                return x;

            vis[x] = true;
        }

        return -1;
    }
}