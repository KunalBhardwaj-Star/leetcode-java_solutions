class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans = 0;

        for(int i = 0 ; i < nums.size() ; i++){
            int distinct = 0 ;
            boolean seen[] = new boolean[101];

            for(int j = i ; j < nums.size() ; j++){

                int curr = nums.get(j);

                if(!seen[curr]){
                    seen[curr] = true;
                    distinct++;
                }

                ans += distinct * distinct;
            }
        }

        return ans;
    }
}