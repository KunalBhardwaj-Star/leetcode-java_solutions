class Solution {
    int[] nums;
    Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }
    
    public int pick(int target) {
        ArrayList<Integer> idx = new ArrayList<>();

        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == target){
                idx.add(i);
            }
        }

        int rdIdx = random.nextInt(idx.size());
        return idx.get(rdIdx);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */