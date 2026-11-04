
import java.util.*;

class Solution {

    class DualHeap {
        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();

        long sumLeft = 0, sumRight = 0;
        int sizeLeft = 0, sizeRight = 0;

        void add(int num) {
            if (left.isEmpty() || num <= left.lastKey()) {
                left.merge(num, 1, Integer::sum);
                sumLeft += num;
                sizeLeft++;
            } else {
                right.merge(num, 1, Integer::sum);
                sumRight += num;
                sizeRight++;
            }
            balance();
        }

        void remove(int num) {
            if (left.containsKey(num)) {
                removeFrom(left, num);
                sumLeft -= num;
                sizeLeft--;
            } else {
                removeFrom(right, num);
                sumRight -= num;
                sizeRight--;
            }
            balance();
        }

        void removeFrom(TreeMap<Integer, Integer> map, int num) {
            int count = map.get(num);
            if (count == 1) map.remove(num);
            else map.put(num, count - 1);
        }

        void balance() {
            while (sizeLeft > sizeRight + 1) {
                int val = left.lastKey();

                removeFrom(left, val);
                sumLeft -= val;
                sizeLeft--;

                right.merge(val, 1, Integer::sum);
                sumRight += val;
                sizeRight++;
            }

            while (sizeLeft < sizeRight) {
                int val = right.firstKey();

                removeFrom(right, val);
                sumRight -= val;
                sizeRight--;

                left.merge(val, 1, Integer::sum);
                sumLeft += val;
                sizeLeft++;
            }
        }

        long getCost() {
            long median = left.lastKey();

            return median * sizeLeft - sumLeft
                    + sumRight - median * sizeRight;
        }
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        long[] cost = new long[n - x + 1];

        DualHeap dh = new DualHeap();

        for (int i = 0; i < n; i++) {
            dh.add(nums[i]);

            if (i >= x) {
                dh.remove(nums[i - x]);
            }

            if (i >= x - 1) {
                cost[i - x + 1] = dh.getCost();
            }
        }

        long INF = Long.MAX_VALUE / 4;

        long[] prev = new long[n + 1];

        for (int j = 1; j <= k; j++) {

            long[] curr = new long[n + 1];
            Arrays.fill(curr, INF);

            for (int i = 1; i <= n; i++) {

                curr[i] = curr[i - 1];

                if (i >= x && prev[i - x] != INF) {
                    curr[i] = Math.min(
                        curr[i],
                        prev[i - x] + cost[i - x]
                    );
                }
            }

            prev = curr;
        }

        return prev[n];
    }
}
