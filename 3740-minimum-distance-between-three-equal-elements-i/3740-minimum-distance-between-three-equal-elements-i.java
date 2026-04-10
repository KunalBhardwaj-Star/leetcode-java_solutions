class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        if(n < 3) return -1;

        int dis = Integer.MAX_VALUE;
        
        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n ; j ++){
                for(int k = j + 1 ; k < n ; k ++){
                    if((nums[i] == nums[j]) && (nums[j] == nums[k])){
                        dis = Math.min(2*(k - i) , dis);
                    }
                }
            }
        }

        return dis == Integer.MAX_VALUE ? -1 : dis;
    }
}