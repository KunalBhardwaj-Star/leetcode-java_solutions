class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] as = new int[n] , bs = new int[n];
        int count = Integer.MAX_VALUE;

        for(int i = 1 ; i < n ; i++){
            as[n-i-1] += s.charAt(n-i) == 'a' ? as[n-i] + 1 : as[n-i];
            bs[i] += s.charAt(i-1) == 'b' ? bs[i-1] + 1 : bs[i-1];
        }

        for(int i = 0 ; i < n ; i++){
            count = Math.min(as[i] + bs[i]  , count) ;
        }

        return count;
    }
}