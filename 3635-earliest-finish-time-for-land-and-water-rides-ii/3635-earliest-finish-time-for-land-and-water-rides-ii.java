import java.util.*;

class Solution {

    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
            int[] waterStartTime, int[] waterDuration) {

        long ans = Long.MAX_VALUE;

        ans = Math.min(ans, solve(landStartTime, landDuration,
                waterStartTime, waterDuration));

        ans = Math.min(ans, solve(waterStartTime, waterDuration,
                landStartTime, landDuration));

        return (int) ans;
    }

    private long solve(int[] start1, int[] dur1,
            int[] start2, int[] dur2) {

        int m = start2.length;

        int[][] rides = new int[m][2];
        for (int i = 0; i < m; i++) {
            rides[i][0] = start2[i];
            rides[i][1] = dur2[i];
        }

        Arrays.sort(rides, Comparator.comparingInt(a -> a[0]));

        int[] starts = new int[m];
        long[] prefixMinDuration = new long[m];
        long[] suffixMinFinish = new long[m];

        for (int i = 0; i < m; i++) {
            starts[i] = rides[i][0];
        }

        prefixMinDuration[0] = rides[0][1];
        for (int i = 1; i < m; i++) {
            prefixMinDuration[i] = Math.min(prefixMinDuration[i - 1], rides[i][1]);
        }

        suffixMinFinish[m - 1] = (long) rides[m - 1][0] + rides[m - 1][1];

        for (int i = m - 2; i >= 0; i--) {
            long finish = (long) rides[i][0] + rides[i][1];
            suffixMinFinish[i] = Math.min(finish, suffixMinFinish[i + 1]);
        }

        long best = Long.MAX_VALUE;

        for (int i = 0; i < start1.length; i++) {

            long finish1 = (long) start1[i] + dur1[i];

            int pos = upperBound(starts, finish1) - 1;

            if (pos >= 0) {
                best = Math.min(best,
                        finish1 + prefixMinDuration[pos]);
            }

            int next = pos + 1;
            if (next < m) {
                best = Math.min(best,
                        suffixMinFinish[next]);
            }
        }

        return best;
    }

    private int upperBound(int[] arr, long target) {
        int l = 0, r = arr.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}