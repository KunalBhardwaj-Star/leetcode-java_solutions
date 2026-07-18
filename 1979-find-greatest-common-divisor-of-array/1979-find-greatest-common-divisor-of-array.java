class Solution {
    private int gcd(int n1 , int n2){
        while(n2 != 0){
            int temp = n2;
            n2 = n1 % n2;
            n1 = temp;
        }

        return n1;
    }
    public int findGCD(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int lft = 0 , rght = nums.length - 1;

        while(lft <= rght){
            max = Math.max(max , Math.max(nums[lft] , nums[rght]));
            min = Math.min(min , Math.min(nums[lft] , nums[rght]));

            lft++;
            rght--;
        }

        return gcd(min , max);
    }
}