class Solution {
    public int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] < 0)
                neg.add(nums[i]);
            else 
                pos.add(nums[i]);
        }

        int pos_idx = 0 , neg_idx = 0;
        int idx = 0;

        while(idx < nums.length){
            nums[idx++] = pos.get(pos_idx++);
            nums[idx++] = neg.get(neg_idx++);
        }

        return nums;
    }
}