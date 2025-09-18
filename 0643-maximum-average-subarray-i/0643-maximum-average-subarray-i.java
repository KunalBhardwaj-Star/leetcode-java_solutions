import java.util.*;

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0 ;
        int arr_size = nums.length;
        
        for(int i = 0 ; i < k ; i++){
            sum += (double)nums[i];
        }

        double max_Sum = sum;

        for(int i = k; i < arr_size ; i++ ){
            sum += nums[i] - nums[i-k];
            max_Sum = Math.max(max_Sum , sum);
        }

        return max_Sum/(double)k;
    }
}