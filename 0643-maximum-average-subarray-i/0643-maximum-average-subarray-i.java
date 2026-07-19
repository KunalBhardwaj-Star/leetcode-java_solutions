class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int lft = 0;
        int n = nums.length;

        double sum = 0;

        double max = Double.NEGATIVE_INFINITY;

        for(int rght = 0 ; rght < n ; rght++){
            sum += nums[rght];
            if(rght - lft + 1 == k){
                max = Math.max(max , sum);
                sum -= nums[lft];
                lft++;
            }
        }

        return max / k;
    }
}