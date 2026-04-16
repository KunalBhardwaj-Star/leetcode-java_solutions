import java.util.*;

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> ans = new ArrayList<>();

        for (int idx : queries) {
            int val = nums[idx];
            List<Integer> list = map.get(val);

            if (list.size() == 1) {
                ans.add(-1);
                continue;
            }

            int pos = Collections.binarySearch(list, idx);

            int left = (pos - 1 + list.size()) % list.size();
            int right = (pos + 1) % list.size();

            int leftIdx = list.get(left);
            int rightIdx = list.get(right);

            int distLeft = getDist(idx, leftIdx, n);
            int distRight = getDist(idx, rightIdx, n);

            ans.add(Math.min(distLeft, distRight));
        }

        return ans;
    }

    private int getDist(int i, int j, int n) {
        int diff = Math.abs(i - j);
        return Math.min(diff, n - diff);
    }
}