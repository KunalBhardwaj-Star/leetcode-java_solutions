class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];

        int left = 0, right = n , i = 0;

        while(right < 2 * n){
            ans[i] = nums[left];
            ans[i+1] = nums[right];
            left++;
            right++;
            i += 2;
        }

        return ans;
    }
}