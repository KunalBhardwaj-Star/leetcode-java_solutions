class Solution {
    public int distinctSubseqII(String s) {
        int n = s.length();

        int dp = 0;

        int[] freq = new int[26];

        int MOD = 1000000007;

        for(char ch : s.toCharArray()){
            int new_dp = (2 * dp + 1 - freq[ch - 'a']) % MOD;

            if(new_dp < 0)
                new_dp += MOD;
                
            freq[ch - 'a'] = dp + 1;
            dp = new_dp;
        }

        return dp;
    }
}