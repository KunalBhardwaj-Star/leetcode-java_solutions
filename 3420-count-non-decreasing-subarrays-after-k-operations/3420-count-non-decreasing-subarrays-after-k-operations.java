
import java.util.*;

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;

        Deque<int[]> dq = new ArrayDeque<>();

        long ans = 0;
        long cost = 0;

        int right = n - 1;

        for (int left = n - 1; left >= 0; left--) {

            int num = nums[left];
            int count = 1;

            while (!dq.isEmpty() && dq.peekLast()[0] < num) {

                int[] curr = dq.pollLast();

                cost += (long) (num - curr[0]) * curr[1];

                count += curr[1];
            }

            dq.offerLast(new int[]{num, count});

            while (cost > k) {

                int[] curr = dq.peekFirst();

                int value = curr[0];
                int cnt = curr[1];

                dq.pollFirst();

                cost -= (long) (value - nums[right]);

                if (cnt > 1) {
                    dq.offerFirst(new int[]{value, cnt - 1});
                }

                right--;
            }

            ans += right - left + 1;
        }

        return ans;
    }
}
