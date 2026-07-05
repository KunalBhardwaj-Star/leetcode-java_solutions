class Solution {

    public int[] pathsWithMaxScore(List<String> board) {

        int n = board.size();
        int MOD = 1_000_000_007;

        int[][] score = new int[n][n];
        long[][] ways = new long[n][n];

        for (int[] row : score) {
            Arrays.fill(row, -1);
        }

        score[0][0] = 0;
        ways[0][0] = 1;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (board.get(i).charAt(j) == 'X')
                    continue;

                if (i == 0 && j == 0)
                    continue;

                int best = -1;
                long count = 0;

                int[][] dirs = {
                    {-1, 0},
                    {0, -1},
                    {-1, -1}
                };

                for (int[] d : dirs) {

                    int ni = i + d[0];
                    int nj = j + d[1];

                    if (ni < 0 || nj < 0)
                        continue;

                    if (score[ni][nj] == -1)
                        continue;

                    if (score[ni][nj] > best) {
                        best = score[ni][nj];
                        count = ways[ni][nj];
                    }
                    else if (score[ni][nj] == best) {
                        count = (count + ways[ni][nj]) % MOD;
                    }
                }

                if (best == -1)
                    continue;

                char ch = board.get(i).charAt(j);

                int val = 0;
                if (ch != 'S' && ch != 'E')
                    val = ch - '0';

                score[i][j] = best + val;
                ways[i][j] = count;
            }
        }

        if (ways[n - 1][n - 1] == 0)
            return new int[]{0, 0};

        return new int[]{
            score[n - 1][n - 1],
            (int)(ways[n - 1][n - 1] % MOD)
        };
    }
}