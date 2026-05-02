class Solution {
    public List<Integer> findValidElements(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();

        int len = nums.length;

        int[] lMax = new int[len];
        int[] rMax = new int[len];

        lMax[0] = 0;
        rMax[len - 1] = len - 1;

        for(int i = 1 ; i < len ; i++) lMax[i] = nums[i] > nums[lMax[i-1]] ? i : lMax[i-1];
        for(int i = len - 2 ; i >= 0 ; i--) rMax[i] = nums[i] > nums[rMax[i+1]] ? i : rMax[i+1];

        for(int i = 0 ; i < len ; i++){
            if(i - lMax[i] == 0 || i - rMax[i] == 0) ans.add(nums[i]);
        }

        return ans;
    }
}