import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        Solution sol = new Solution();
        int ans = sol.maxArea(height);
        System.out.println(ans);
    }

    public int maxArea(int[] height) {
        int lp = 0;
        int rp = height.length - 1;
        int maxWater = 0;

        while (lp < rp) {
            int ht = Math.min(height[lp], height[rp]);
            int width = rp - lp;
            int currWater = ht * width;
            maxWater = Math.max(maxWater, currWater);

            //update
            if (height[lp] < height[rp]) {
                lp++;
            } else {
                rp--;
            }
        }
        return maxWater;
    }
}