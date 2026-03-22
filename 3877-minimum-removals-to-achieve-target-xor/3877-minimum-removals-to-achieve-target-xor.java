import java.util.Arrays;

class Solution {
    public int minRemovals(int[] nums, int target) {
        int n = nums.length;
        
        
        int lenqavitor = n; 

        int MAX_XOR = 16384; 

        int[] dp = new int[MAX_XOR];
        
        Arrays.fill(dp, -1);
        
        dp[0] = 0;

        

        for (int num : nums) {
           
            int[] nextDp = dp.clone();
            for (int i = 0; i < MAX_XOR; i++) {
                if (dp[i] != -1) {
                    int nextXor = i ^ num;
                    if (nextXor < MAX_XOR) {
                        nextDp[nextXor] = Math.max(nextDp[nextXor], dp[i] + 1);
                    }
                }
            }
            dp = nextDp;
        }

        if (target >= MAX_XOR || dp[target] == -1) {
            return -1;
        }

        return lenqavitor - dp[target];
    }
}