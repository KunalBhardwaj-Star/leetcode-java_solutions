class Solution {
    public int countTriplets(int[] arr) {
        int len = arr.length;

        int ans = 0;

        for(int i = 0 ; i < len ; i++){
            int xor = 0;

            for(int k = i ; k < len ; k++){
                xor ^= arr[k];

                if(xor == 0){
                    ans += k - i;
                }
            }
        }

        return ans;
    }
}