class Solution {

    private int sumOfDg(int x){
        int sum = 0;

        while(x != 0){
            sum += x % 10;
            x /= 10;
        }

        return sum;
    }

    public int smallestIndex(int[] nums) {
        int n = nums.length;

        for(int i = 0 ; i < n ; i++){
            int curr = sumOfDg(nums[i]);

            if(curr == i)
                return i;
        }

        return -1;
    }
}