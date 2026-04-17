class Solution {

    private int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            rev = rev * 10 + (x % 10);
            x /= 10;
        }
        return rev;
    }

    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];

            if (map.containsKey(x)) {
                ans = Math.min(ans, i - map.get(x));
            }

            int rev = reverse(x);

            map.put(rev, i);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}