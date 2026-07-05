class Solution {
    List<List<Integer>> ans;

    private void backtrack(int[] nums , int start , int target , ArrayList<Integer> list){
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }

        if(target < 0){
            return;
        }

        for(int i = start ; i < nums.length ; i++){
            list.add(nums[i]);
            backtrack(nums , i , target - nums[i] , list);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        backtrack(candidates , 0 , target , new ArrayList<>());

        return ans;
    }
}