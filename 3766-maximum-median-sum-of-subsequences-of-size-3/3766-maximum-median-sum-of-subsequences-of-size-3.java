import java.util.*;

class Solution {
    public long maximumMedianSum(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length/3;
        int index = nums.length - 2;
        long maxMedianSum = 0;

        for(int i = 0; i < n ; i++){
            maxMedianSum += (long)nums[index];
            index -= 2;
        }
        return maxMedianSum;
    }
}