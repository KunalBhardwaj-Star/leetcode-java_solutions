class Solution {

    private String num;
    private Pair[][][][][] memo;

    static class Pair {
        long count;
        long waviness;

        Pair(long count, long waviness) {
            this.count = count;
            this.waviness = waviness;
        }
    }

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long x) {
        if (x < 0)
            return 0;

        num = String.valueOf(x);

        memo = new Pair[num.length()][2][2][11][11];

        return dfs(0, 1, 0, 10, 10).waviness;
    }

    private Pair dfs(int pos,
            int tight,
            int started,
            int prevPrev,
            int prev) {

        if (pos == num.length()) {
            return new Pair(1, 0);
        }

        if (memo[pos][tight][started][prevPrev][prev] != null) {
            return memo[pos][tight][started][prevPrev][prev];
        }

        int limit = tight == 1 ? num.charAt(pos) - '0' : 9;

        long totalCount = 0;
        long totalWaviness = 0;

        for (int digit = 0; digit <= limit; digit++) {

            int nextTight = (tight == 1 && digit == limit) ? 1 : 0;

            if (started == 0 && digit == 0) {

                Pair child = dfs(
                        pos + 1,
                        nextTight,
                        0,
                        10,
                        10);

                totalCount += child.count;
                totalWaviness += child.waviness;

            } else {

                int add = 0;

                if (started == 1 && prevPrev != 10) {

                    boolean peak = prev > prevPrev && prev > digit;

                    boolean valley = prev < prevPrev && prev < digit;

                    if (peak || valley) {
                        add = 1;
                    }
                }

                int newPrevPrev = (started == 0) ? 10 : prev;

                int newPrev = digit;

                Pair child = dfs(
                        pos + 1,
                        nextTight,
                        1,
                        newPrevPrev,
                        newPrev);

                totalCount += child.count;

                totalWaviness += child.waviness +
                        child.count * add;
            }
        }

        return memo[pos][tight][started][prevPrev][prev] = new Pair(totalCount, totalWaviness);
    }
}