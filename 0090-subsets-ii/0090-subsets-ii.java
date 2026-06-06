class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    private void backtrack(int idx , int[] nums , List<Integer> current){
        if(idx == nums.length){
            if(!ans.contains(current))
                ans.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[idx]);

        backtrack(idx + 1 , nums , current);

        current.remove(current.size() - 1);

        backtrack(idx + 1 , nums , current);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(0 , nums , new ArrayList<>());
        return ans;
    }
}