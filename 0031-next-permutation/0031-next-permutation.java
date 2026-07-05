class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        int i = n - 2;

        while(i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }

        int j = n - 1;

        if(i >= 0){
            while(nums[j] <= nums[i]){
                j--;
            }

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        int lft = i + 1;
        int rght = n - 1;

        while(lft < rght){
            int temp = nums[lft];
            nums[lft] = nums[rght];
            nums[rght] = temp;

            lft++;
            rght--;
        }
    }
}