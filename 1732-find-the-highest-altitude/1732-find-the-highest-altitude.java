class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int[] prefix = new int[n];

        for(int i = 0 ; i < n ; i++){
            prefix[i] = i == 0 ? gain[i] : prefix[i-1] + gain[i];
        }

        int max = 0;

        for(int i = 0 ; i < n ; i++){
            max = Math.max(max , prefix[i]);
        }

        return max;
    }
}