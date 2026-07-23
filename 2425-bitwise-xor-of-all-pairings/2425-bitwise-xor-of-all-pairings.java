class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int ans = 0;

        if(m % 2 == 1){
            for(int n2 : nums2){
                ans ^= n2;
            }
        }

        if(n % 2 == 1){
            for(int n1 : nums1){
                ans ^= n1;
            }
        }

        return ans;
    }
}