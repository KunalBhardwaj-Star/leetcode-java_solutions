class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        solve(0 , nums , new ArrayList<>());
        return ans;
    }

    private void solve(int idx , int[] nums , List<Integer> subset){
        if(idx == nums.length){
            ans.add(new ArrayList<>(subset));
            return;
        }   

        subset.add(nums[idx]);

        solve(idx + 1 , nums , subset);

        subset.remove(subset.size() - 1);

        solve(idx + 1 , nums , subset);
    }
}