class Solution {
    public double findMedianSortedArrays(
        int[] nums1,
        int[] nums2
    ) {

        int n = nums1.length;
        int m = nums2.length;

        int total = n + m;

        int[] merged = new int[total];

        int i = 0, j = 0, k = 0;

        while(i < n && j < m){

            if(nums1[i] < nums2[j]){
                merged[k++] = nums1[i++];
            } else{
                merged[k++] = nums2[j++];
            }
        }

        while(i < n){
            merged[k++] = nums1[i++];
        }

        while(j < m){
            merged[k++] = nums2[j++];
        }

        if(total % 2 == 1){
            return merged[total / 2];
        }

        return (
            merged[total / 2]
            + merged[(total / 2) - 1]
        ) / 2.0;
    }
}