class Solution {

    private int sumOfDigits(int x){
        if(x == 0)
            return 0;

        return (x % 10) + sumOfDigits(x / 10);
    }

    public int minElement(int[] nums) {
        int min_sum = Integer.MAX_VALUE;
        for(int x : nums){
            int curr_sum = sumOfDigits(x);

            min_sum = Math.min(min_sum , curr_sum);
        }

        return min_sum;
    }
}