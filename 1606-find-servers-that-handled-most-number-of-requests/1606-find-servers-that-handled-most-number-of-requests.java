import java.util.*;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        int[] count = new int[k];
        int n = arrival.length;

        for (int i = 0; i < n; i++) {
            int start = arrival[i];
            int duration = load[i];

            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                available.add(busy.poll()[1]);
            }

            if (available.isEmpty()) {
                continue;
            }

            int target = i % k;
            Integer server = available.ceiling(target);
            
            if (server == null) {
                server = available.first();
            }

            available.remove(server);
            count[server]++;
            busy.offer(new int[]{start + duration, server});
        }

        int maxRequests = 0;
        for (int c : count) {
            maxRequests = Math.max(maxRequests, c);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (count[i] == maxRequests) {
                result.add(i);
            }
        }

        return result;
    }
}