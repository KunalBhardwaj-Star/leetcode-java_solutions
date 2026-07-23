class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int len = arr.length;

        int queriesLength = queries.length;

        int[] prefixXOR = new int[len];

        int[] ans = new int[queriesLength];

        prefixXOR[0] = arr[0];

        for(int i = 1 ; i < len ; i++){
            prefixXOR[i] = prefixXOR[i-1] ^ arr[i];
        }

        int idx = 0;

        for(int[] curr : queries){
            int start = curr[0];
            int end = curr[1];

            ans[idx] = start == 0 ? prefixXOR[end] : prefixXOR[end] ^ prefixXOR[start - 1];
            idx++;
        }

        return ans;
    }
}