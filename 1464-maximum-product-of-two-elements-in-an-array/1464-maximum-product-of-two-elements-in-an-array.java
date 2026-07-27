class Solution {
    int max1 = Integer.MIN_VALUE , max2 = Integer.MIN_VALUE;

    private void helper(int[] nums){
        int lft = 0 , rght = nums.length - 1;

        while(lft <= rght){
            if(max1 < nums[lft]){
                max2 = max1;
                max1 = nums[lft];
            } else if(max2 < nums[lft]){
                max2 = nums[lft];
            }

            if(max1 < nums[rght]){
                max2 = max1;
                max1 = nums[rght];
            } else if(max2 < nums[rght]){
                max2 = nums[rght];
            }

            lft++;
            rght--;
        }
    }

    public int maxProduct(int[] nums) {
        helper(nums);
        return (max1 - 1)*(max2 - 1);
    }
}