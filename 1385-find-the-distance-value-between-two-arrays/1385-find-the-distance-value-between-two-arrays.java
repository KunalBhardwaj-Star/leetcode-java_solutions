class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int ans = 0;

        for(int x : arr1){
            int low = 0;
            int high = arr2.length - 1;
            int idx = arr2.length;
            int target = x - d;

            while(low <= high){
                int mid = (low + high) / 2;

                if(arr2[mid] >= target){
                    idx = mid;
                    high = mid - 1;
                } else{
                    low = mid + 1;
                }
            }

            if(idx == arr2.length || arr2[idx] > x + d)
                ans++;
        }

        return ans;
    }
}