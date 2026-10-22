
import java.util.*;

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        if (n <= 1) {
            return 0;
        }

        int zeroIndex = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeroIndex = i;
                break;
            }
        }

        int[][] dist = new int[2][n];
        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        dist[0][0] = 0;

        while (!queue.isEmpty()) {
            int[] state = queue.poll();
            int orientation = state[0];
            int shift = state[1];
            int d = dist[orientation][shift];

            int start = orientation == 0
                    ? shift
                    : (n - 1 - shift + n) % n;

            boolean sorted = true;

            for (int i = 0; i < n; i++) {
                int index;

                if (orientation == 0) {
                    index = (start + i) % n;
                } else {
                    index = (n - 1 - ((shift + i) % n) + n) % n;
                }

                if (nums[index] != i) {
                    sorted = false;
                    break;
                }
            }

            if (sorted) {
                return d;
            }

            int nextShift = (shift + 1) % n;

            if (dist[orientation][nextShift] == -1) {
                dist[orientation][nextShift] = d + 1;
                queue.offer(new int[]{orientation, nextShift});
            }

            int reverseShift = (n - shift) % n;
            int nextOrientation = 1 - orientation;

            if (dist[nextOrientation][reverseShift] == -1) {
                dist[nextOrientation][reverseShift] = d + 1;
                queue.offer(new int[]{
                    nextOrientation, reverseShift
                });
            }
        }

        return -1;
    }
}
