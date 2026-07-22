class Solution {
    public List<String> buildArray(int[] target, int n) {
        int len = target.length;
        List<String> ans = new ArrayList<>();

        if(n == 0)
            return ans;

        int idx = 0;

        for(int i = 0 ; i < n && idx < len ; i++){
            if(i + 1 == target[idx]){
                ans.add("Push");
                idx++;
            } else{
                ans.add("Push");
                ans.add("Pop");
            }
        }

        return ans;
    }
}