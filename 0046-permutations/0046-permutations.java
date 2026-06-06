class Solution {
    ArrayList<List<Integer>> ans = new ArrayList<>();
    private void backtrack(int[] nums , ArrayList<Integer> current , boolean[] used){
        if(current.size() == nums.length){
            ans.add(new ArrayList<>(current));
            return;
        }

        for(int i = 0 ; i < nums.length ; i++){
            if(used[i]) continue;

            current.add(nums[i]);

            used[i] = true;

            backtrack(nums, current , used);

            current.remove(current.size() - 1);

            used[i] = false;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums , new ArrayList<>() , new boolean[nums.length]);
        return ans;
    }
}