class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            if(i > 0 && nums[i] == nums[i-1])
                continue;

            int lft = i + 1 , rght = n - 1;

            while(lft < rght){
                int sum = nums[i] + nums[lft] + nums[rght];

                if(sum == 0){
                    ans.add(Arrays.asList(
                        nums[i],
                        nums[lft],
                        nums[rght]
                    ));

                    lft++;
                    rght--;

                    while(lft < rght && nums[lft] == nums[lft-1])
                        lft++;

                    while(lft < rght && nums[rght] == nums[rght+1])
                        rght--;
                } else if(sum < 0){
                    lft++;
                } else{
                    rght--;
                }
            }
        }

        return ans;
    }
}