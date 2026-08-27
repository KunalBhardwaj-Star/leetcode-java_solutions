class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int n = nums.length;

        int closest = nums[0] + nums[1] + nums[2];

        for(int i = 0 ; i < n - 2 ; i++){
            int lft = i + 1 , rght = n - 1;

            while(lft < rght){
                int sum = nums[i] + nums[lft] + nums[rght];

                if(sum == target)
                    return target;

                if(Math.abs(sum - target) < Math.abs(closest - target))
                    closest = sum;

                if(sum < target)
                    lft++;

                else 
                    rght--;
            }
        }

        return closest;
    }
}