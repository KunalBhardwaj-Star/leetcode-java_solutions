class Solution {
    public int trap(int[] height) {
        int maxVol = 0 , n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        for(int i = 1 ; i < n ; i++)leftMax[i] = Math.max(leftMax[i-1] , height[i]);
        rightMax[n-1] = height[n-1];
        for(int i = n-2 ; i >= 0 ; i--)rightMax[i] = Math.max(rightMax[i+1] , height[i]);
        for(int i = 1 ; i < n-1 ; i++){
            maxVol += Math.min(leftMax[i-1] , rightMax[i+1]) - height[i] >= 0 ? Math.min(leftMax[i-1] , rightMax[i+1]) - height[i] : 0;
        }
        return maxVol;
    }
}