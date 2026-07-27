class Solution {
    private int binarySearch(int[] nums , int low , int high , int target){
        if(low > high)
            return -1;

        int mid = (low + high) / 2;

        if(nums[mid] == target)
            return mid;

        if(nums[low] <= nums[mid]){
            if(nums[low] <= target && nums[mid] > target)
                high = mid - 1;

            else 
                low = mid + 1;
        }

        else{
            if(nums[mid] < target && nums[high] >= target){
                low = mid + 1;
            } 
            else
                high = mid - 1;
        }

        return binarySearch(nums , low , high , target);
    }
    public int search(int[] nums, int target) {
        return binarySearch(nums , 0 , nums.length - 1, target);
    }
}