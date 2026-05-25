class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int len = s.length();

        boolean[] dp = new boolean[len];

        dp[0] = true;

        int reachableCount = 0;

        for(int i = 0 ; i < len ; i++){
            if(i - minJump >= 0 && dp[i - minJump])
                reachableCount++;

            if(i - 1 - maxJump >= 0 && dp[i - 1 - maxJump])
                reachableCount--;
            
            if(s.charAt(i) == '0' && reachableCount > 0)
                dp[i] = true;
        }

        return dp[len - 1];
    }
}