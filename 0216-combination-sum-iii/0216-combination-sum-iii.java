class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    private void backtrack(int start , int n , int k , int sum , List<Integer> list){
        if(sum == n && list.size() == k){
            ans.add(new ArrayList<>(list));
            return;
        }

        if(sum > n || list.size() == k)
            return;

        for(int i = start ; i <= 9 ; i++){
            list.add(i);
            backtrack(i + 1 , n , k , sum + i , list);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(1 , n , k , 0 , new ArrayList<>());
        return ans;
    }
}