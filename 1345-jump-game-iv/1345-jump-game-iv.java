import java.util.*;

class Solution {

    public int minJumps(int[] arr) {

        int n = arr.length;

        if(n == 1) return 0;

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.offer(0);
        visited[0] = true;

        int steps = 0;

        while(!q.isEmpty()) {

            int size = q.size();

            for(int k = 0; k < size; k++) {

                int curr = q.poll();

                if(curr == n - 1) {
                    return steps;
                }

                int next = curr + 1;

                if(next < n && !visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }

                next = curr - 1;

                if(next >= 0 && !visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }

                if(map.containsKey(arr[curr])) {

                    for(int idx : map.get(arr[curr])) {

                        if(!visited[idx]) {
                            visited[idx] = true;
                            q.offer(idx);
                        }
                    }

                    map.remove(arr[curr]);
                }
            }

            steps++;
        }

        return -1;
    }
}