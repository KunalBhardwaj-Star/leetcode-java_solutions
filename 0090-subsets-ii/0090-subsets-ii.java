class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    private void backtrack(int idx , int[] nums , List<Integer> current){
        ans.add(new ArrayList<>(current));

        for(int i = idx ; i < nums.length ; i++){
            if(i > idx && nums[i] == nums[i-1])
                continue;

            current.add(nums[i]);
            backtrack(i + 1 , nums , current);
            current.remove(current.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(0 , nums , new ArrayList<>());
        return ans;
    }
}