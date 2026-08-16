class Solution {

    private Boolean[] dp;
    private Set<String> words;

    public boolean wordBreak(String s, List<String> wordDict) {

        words = new HashSet<>(wordDict);
        dp = new Boolean[s.length()];

        return dfs(0, s);
    }

    private boolean dfs(int idx, String s) {

        if(idx == s.length())
            return true;

        if(dp[idx] != null)
            return dp[idx];

        for(int end = idx; end < s.length(); end++) {

            String curr = s.substring(idx, end + 1);

            if(words.contains(curr) && dfs(end + 1, s)) {
                return dp[idx] = true;
            }
        }

        return dp[idx] = false;
    }
}