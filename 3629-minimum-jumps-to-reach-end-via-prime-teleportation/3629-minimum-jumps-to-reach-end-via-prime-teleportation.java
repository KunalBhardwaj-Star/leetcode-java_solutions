import java.util.*;

class Solution {

    private boolean isPrime(int x) {

        if (x <= 1) return false;

        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) return false;
        }

        return true;
    }

    private List<Integer> getPrimeFactors(int x) {

        List<Integer> factors = new ArrayList<>();

        if (x % 2 == 0) {

            factors.add(2);

            while (x % 2 == 0) {
                x /= 2;
            }
        }

        for (int i = 3; i * i <= x; i += 2) {

            if (x % i == 0) {

                factors.add(i);

                while (x % i == 0) {
                    x /= i;
                }
            }
        }

        if (x > 1) {
            factors.add(x);
        }

        return factors;
    }

    public int minJumps(int[] nums) {

        int n = nums.length;

        HashMap<Integer, List<Integer>> bucket = new HashMap<>();

        for (int i = 0; i < n; i++) {

            List<Integer> factors = getPrimeFactors(nums[i]);

            for (int p : factors) {

                bucket.putIfAbsent(p, new ArrayList<>());

                bucket.get(p).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();

        boolean[] visited = new boolean[n];

        q.offer(0);

        visited[0] = true;

        int jumps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int idx = q.poll();

                if (idx == n - 1) {
                    return jumps;
                }

                if (idx - 1 >= 0 && !visited[idx - 1]) {

                    visited[idx - 1] = true;

                    q.offer(idx - 1);
                }

                if (idx + 1 < n && !visited[idx + 1]) {

                    visited[idx + 1] = true;

                    q.offer(idx + 1);
                }

                if (isPrime(nums[idx])) {

                    int prime = nums[idx];

                    if (bucket.containsKey(prime)) {

                        for (int next : bucket.get(prime)) {

                            if (!visited[next]) {

                                visited[next] = true;

                                q.offer(next);
                            }
                        }

                        bucket.remove(prime);
                    }
                }
            }

            jumps++;
        }

        return -1;
    }
}