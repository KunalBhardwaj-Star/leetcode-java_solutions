class Solution {
    public int maxArea(int[] height) {
        int lft = 0;
        int rght = height.length - 1;

        int max = 0;

        while(lft < rght){
            int width = rght - lft;
            int hght = Math.min(height[lft] , height[rght]);
            int currArea = width * hght;

            max = Math.max(max , currArea);

            if(height[lft] < height[rght])
                lft++;

            else 
                rght--;

        }

        return max;
    }
}