import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int sr = 0;
        int sc = 0;

        ArrayList<int[]> litter = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    sr = i;
                    sc = j;
                } else if (ch == 'L') {
                    litter.add(new int[]{i, j});
                }
            }
        }

        int countL = litter.size();

        if (countL == 0) {
            return 0;
        }

        int[][] litterId = new int[m][n];

        for (int[] row : litterId) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < countL; i++) {
            int r = litter.get(i)[0];
            int c = litter.get(i)[1];

            litterId[r][c] = i;
        }

        int fullMask = (1 << countL) - 1;

        boolean[][][][] visited =
            new boolean[m][n][energy + 1][1 << countL];

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{sr, sc, energy, 0, 0});
        visited[sr][sc][energy][0] = true;

        int[][] dir = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];
            int e = curr[2];
            int mask = curr[3];
            int moves = curr[4];

            if (mask == fullMask) {
                return moves;
            }

            if (e == 0) {
                continue;
            }

            for (int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }

                if (classroom[nr].charAt(nc) == 'X') {
                    continue;
                }

                int ne = e - 1;
                int nmask = mask;

                if (classroom[nr].charAt(nc) == 'R') {
                    ne = energy;
                }

                if (litterId[nr][nc] != -1) {
                    nmask |= (1 << litterId[nr][nc]);
                }

                if (!visited[nr][nc][ne][nmask]) {
                    visited[nr][nc][ne][nmask] = true;

                    q.offer(new int[]{
                        nr,
                        nc,
                        ne,
                        nmask,
                        moves + 1
                    });
                }
            }
        }

        return -1;
    }
}