class Solution {
    public int[] findErrorNums(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        int n = nums.length;

        int [] ans = new int[2];

        for(int i = 0 ; i < n ; i++){
            if(set.contains(nums[i]))
                ans[0] = nums[i];

            set.add(nums[i]);
        }

        for(int i = 1; i <=n ; i++){
            if(!set.contains(i)){
                ans[1] = i;
                break;
            }
        }

        return ans;
    }
}