import java.util.*;

class Solution {

    class Node {
        long score;
        List<Integer> list;

        Node(long score, List<Integer> list) {
            this.score = score;
            this.list = list;
        }
    }

    int n;
    int[][] arr;
    Node[][] dp;

    public int[] maximumWeight(List<List<Integer>> intervals) {

        n = intervals.size();

        arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);

            return Integer.compare(a[1], b[1]);
        });

        dp = new Node[n + 1][5];

        Node ans = solve(0, 4);

        int[] result = new int[ans.list.size()];

        for (int i = 0; i < ans.list.size(); i++) {
            result[i] = ans.list.get(i);
        }

        return result;
    }

    private Node solve(int i, int k) {

        if (i == n || k == 0) {
            return new Node(0, new ArrayList<>());
        }

        if (dp[i][k] != null) {
            return dp[i][k];
        }

        Node skip = solve(i + 1, k);

        int next = findNext(i);

        Node nextResult = solve(next, k - 1);

        long takeScore = arr[i][2] + nextResult.score;

        List<Integer> takeList = new ArrayList<>();

        takeList.add(arr[i][3]);
        takeList.addAll(nextResult.list);

        Collections.sort(takeList);

        Node take = new Node(takeScore, takeList);

        Node best;

        if (take.score > skip.score) {

            best = take;

        } else if (take.score < skip.score) {

            best = skip;

        } else {

            if (isSmaller(take.list, skip.list)) {
                best = take;
            } else {
                best = skip;
            }
        }

        dp[i][k] = best;

        return best;
    }

    private int findNext(int i) {

        int low = i + 1;
        int high = n - 1;

        int answer = n;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid][0] > arr[i][1]) {

                answer = mid;
                high = mid - 1;

            } else {

                low = mid + 1;
            }
        }

        return answer;
    }

    private boolean isSmaller(List<Integer> a, List<Integer> b) {

        int size = Math.min(a.size(), b.size());

        for (int i = 0; i < size; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        return a.size() < b.size();
    }
}