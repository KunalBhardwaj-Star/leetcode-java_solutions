class Solution {
    private int rev(int n){
        int reverse = 0;

        while(n != 0){
            reverse = (reverse * 10) + (n % 10);
            n /= 10;
        }

        return reverse;
    }
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer , Integer> map = new HashMap<>();

        int len = nums.length;

        int min = Integer.MAX_VALUE;

        for(int i = 0 ; i < len ; i++){
            int x = nums[i];

            if(map.containsKey(x)) min = Math.min(min , i - map.get(x));
            int reverse = rev(nums[i]);
            map.put(reverse , i);
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}