class Solution {
    private int gcd(int x , int y){
        while(y != 0){
            int temp = y;
            y = x % y;
            x = temp;
        }

        return x;
    }
    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for(int i = 0 ; i < n ; i++){
            long p = 1;
            int g = 0;
            int l = 1;

            for(int j = i ; j < n ; j++){
                p *= (long)nums[j];

                g = gcd(g , nums[j]);
                l = l / gcd(l , nums[j]) * nums[j];

                if(p == (long) g * l)
                    ans = Math.max(j - i + 1 , ans);
            }
        }

        return ans;
    }
}