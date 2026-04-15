class Solution {
    public int singleNonDuplicate(int[] nums) {
        int len = nums.length;

        if(len == 1) return nums[0];

        int l = 0 , r = len - 1;

        while(l < r){
            int mid = (l + r) / 2;

            if(mid % 2 == 1) mid--;

            if(nums[mid] == nums[mid + 1]) l = mid + 2;

            else r = mid;
        }

        return nums[l];
    }
}