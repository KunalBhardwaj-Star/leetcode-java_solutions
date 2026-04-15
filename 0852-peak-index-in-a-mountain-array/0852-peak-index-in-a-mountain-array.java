class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int len = arr.length;

        int l = 0 , r = len - 1;

        int peak = Integer.MIN_VALUE;
        int idx = 0;

        while(l <= r){
            if(peak < arr[l]){
                peak = arr[l];
                idx = l;
            }
            if(peak < arr[r]){
                peak = arr[r];
                idx = r;
            }

            l++;
            r--;
        }

        return idx;
    }
}