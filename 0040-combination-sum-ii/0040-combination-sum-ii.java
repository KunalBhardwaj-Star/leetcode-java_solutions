class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    private void backtrack(int start , int target , int[] nums , List<Integer>curr){
        if(target == 0){           
            if(!ans.contains(curr))
                ans.add(new ArrayList<>(curr));
            
            return;
        }

        if(target < 0)
            return;

        for(int i = start ; i < nums.length ; i++){
            if(i > start && nums[i] == nums[i - 1])
                continue;

            if(nums[i] > target)
                break;
            
            curr.add(nums[i]);
            backtrack(i + 1 , target - nums[i] , nums , curr);

            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        backtrack(0 , target , candidates , new ArrayList<>());
        return ans;
    }
}