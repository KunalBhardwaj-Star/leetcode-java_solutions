class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        if(n == 1)
            return intervals;

        ArrayList<int[]> newInterval = new ArrayList<>();

        int u = intervals[0][0];
        int v = intervals[0][1];

        for(int i = 1 ; i < n ; i++){
            if(v >= intervals[i][0])
                v = Math.max(v , intervals[i][1]);

            else {
                newInterval.add(new int[]{u , v});
                u = intervals[i][0];
                v = intervals[i][1];
            }
        }

        newInterval.add(new int[]{u , v});

        int[][] ans = new int[newInterval.size()][2];

        for(int idx = 0 ; idx < newInterval.size() ; idx++){
            ans[idx] = newInterval.get(idx);
        }

        return ans;
    }
}