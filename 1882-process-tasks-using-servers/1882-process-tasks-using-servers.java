
class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {

        int n = servers.length;
        int m = tasks.length;

        int[] ans = new int[m];

        PriorityQueue<int[]> available = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0])
                    return Integer.compare(a[0], b[0]);

                return Integer.compare(a[1], b[1]);
            }
        );

        PriorityQueue<int[]> inProgress = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0])
                    return Integer.compare(a[0], b[0]);

                if (a[1] != b[1])
                    return Integer.compare(a[1], b[1]);

                return Integer.compare(a[2], b[2]);
            }
        );

        for (int i = 0; i < n; i++) {
            available.offer(new int[]{servers[i], i});
        }

        long time = 0;

        for (int i = 0; i < m; i++) {

            time = Math.max(time, i);

            while (!inProgress.isEmpty() &&
                   inProgress.peek()[0] <= time) {

                int[] curr = inProgress.poll();

                available.offer(new int[]{curr[1], curr[2]});
            }

            if (available.isEmpty()) {

                time = inProgress.peek()[0];

                while (!inProgress.isEmpty() &&
                       inProgress.peek()[0] <= time) {

                    int[] curr = inProgress.poll();

                    available.offer(new int[]{curr[1], curr[2]});
                }
            }

            int[] top = available.poll();

            ans[i] = top[1];

            inProgress.offer(new int[]{
                (int)(time + tasks[i]),
                top[0],
                top[1]
            });
        }

        return ans;
    }
}
