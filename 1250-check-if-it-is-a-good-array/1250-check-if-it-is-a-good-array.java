class Solution {

    private int gcd(int a , int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public boolean isGoodArray(int[] nums) {
        int n = nums.length;

        if(n == 1)
            return nums[0] == 1;

        int fact = gcd(nums[0] , nums[1]);

        for(int i = 2; i < n ; i ++){
            fact = gcd(fact , nums[i]);
        }

        return fact == 1;
    }
}