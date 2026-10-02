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
        int len = nums.length;

        if(len == 1)
            return nums[0] == 1;

        int fact = gcd(nums[0] , nums[1]);

        for(int x = 2 ; x < len ; x++){
            fact = gcd(nums[x] , fact);
        }

        return fact == 1;
    }
}