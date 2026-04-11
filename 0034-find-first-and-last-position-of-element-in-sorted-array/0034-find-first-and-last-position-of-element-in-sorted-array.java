class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;

        if(n == 0) return new int[] {-1 , -1};
        if(n == 1 && nums[0] == target) return new int[] {0 , 0};
        if(n == 2 && nums[0] == target && nums[1] == target) return new int[] {0 , 1};
        if(n == 2 && nums[0] == target && nums[1] != target) return new int[] {0 , 0};
        if(n == 2 && nums[0] != target && nums[1] == target) return new int[] {1 , 1};

        int fir = -1 , sec = -1;

        int start = 0 , end = n-1;

        if(nums[n/2] > target) end= n/2;
        else if(nums[n/2] < target) start = n/2 + 1;

        while(start <= end){
            if(fir == -1 && nums[start] == target) fir = start;
            else if(fir != -1 && nums[start] == target) sec = start;
            start++;
        }

        return sec != -1 ? new int[] {fir , sec} : new int[] {fir , fir};
    }
}