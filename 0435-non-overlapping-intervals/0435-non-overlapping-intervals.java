import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int removeCount = 0;
        Arrays.sort(intervals , Comparator.comparingDouble(o -> o[1]));

        int lastSelect = intervals[0][1];
        for (int i =1 ; i < intervals.length ; i++){
            if (intervals[i][0] >= lastSelect){
                lastSelect = intervals[i][1];
            } else {
                removeCount++;
            }
        }
        return removeCount;
    }
}