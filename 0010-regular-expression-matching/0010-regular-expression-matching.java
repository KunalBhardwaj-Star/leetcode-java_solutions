class Solution {
    public boolean isMatch(String s, String p) {

        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[m][n] = true;

        for (int j = n - 2; j >= 0; j--) {
            if (p.charAt(j + 1) == '*') {
                dp[m][j] = dp[m][j + 2];
            }
        }

        for (int i = m - 1; i >= 0; i--) {

            for (int j = n - 1; j >= 0; j--) {

                boolean firstMatch =
                        (s.charAt(i) == p.charAt(j) ||
                         p.charAt(j) == '.');

                if (j + 1 < n && p.charAt(j + 1) == '*') {

                    dp[i][j] =
                            dp[i][j + 2] ||
                            (firstMatch && dp[i + 1][j]);

                } else {

                    dp[i][j] =
                            firstMatch &&
                            dp[i + 1][j + 1];
                }
            }
        }

        return dp[0][0];
    }
}