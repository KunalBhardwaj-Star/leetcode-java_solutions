class Solution {
    public int maxArea(int[] height) {
        int lft = 0 , rght = height.length - 1;

        int max = 0;

        while(lft < rght){
            int hght = Math.min(height[lft] , height[rght]);
            int curr = hght * (rght - lft);
            max = Math.max(max , curr);

            if(height[lft] < height[rght])
                lft++;
            else
                rght--;
        }

        return max;
    }
}