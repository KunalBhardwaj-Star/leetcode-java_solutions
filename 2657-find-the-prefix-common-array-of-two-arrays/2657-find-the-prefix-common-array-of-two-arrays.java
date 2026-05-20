class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int len = A.length;

        int[] ans = new int[len];
        int[] freq = new int[len + 1];
        int common = 0;

        for(int i = 0 ; i < len ; i++){
            freq[A[i]]++;
            if(freq[A[i]] == 2)
                common++;
            
            freq[B[i]]++;
            if(freq[B[i]] == 2)
                common++;

            ans[i] = common;
        }

        return ans;
    }
}