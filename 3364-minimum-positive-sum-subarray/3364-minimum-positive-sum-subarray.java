class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int size = nums.size();

        int ans = Integer.MAX_VALUE;

        for(int i = 0 ; i < size ; i++){
            int sum = 0;
            for(int j = i ; j < size ; j++){
                sum += nums.get(j);

                int len = j - i + 1;

                if(len >= l && len <= r && sum > 0)
                    ans = Math.min(ans , sum);

                if(len > r)
                    break;
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}