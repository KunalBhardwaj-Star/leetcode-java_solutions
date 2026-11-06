
import java.util.*;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        int q = queries.length;
        int[][] queryPairs = new int[q][2];

        for (int i = 0; i < q; i++) {
            queryPairs[i][0] = queries[i];
            queryPairs[i][1] = i;
        }

        Arrays.sort(queryPairs, (a, b) ->
            Integer.compare(a[0], b[0])
        );

        int[] freq = new int[n + 1];
        int[] ans = new int[q];

        int left = 0;
        int right = 0;
        int activeServers = 0;

        for (int[] query : queryPairs) {

            int time = query[0];
            int originalIndex = query[1];

            int windowStart = time - x;

            while (right < logs.length &&
                   logs[right][1] <= time) {

                int server = logs[right][0];

                if (freq[server] == 0) {
                    activeServers++;
                }

                freq[server]++;
                right++;
            }

            while (left < right &&
                   logs[left][1] < windowStart) {

                int server = logs[left][0];

                freq[server]--;

                if (freq[server] == 0) {
                    activeServers--;
                }

                left++;
            }

            ans[originalIndex] = n - activeServers;
        }

        return ans;
    }
}
