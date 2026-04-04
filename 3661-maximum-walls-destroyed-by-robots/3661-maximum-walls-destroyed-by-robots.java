import java.util.*;

class Solution {
    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;
        
        // Create and sort robots by position
        int[][] robotData = new int[n][2];
        for (int i = 0; i < n; i++) {
            robotData[i][0] = robots[i];
            robotData[i][1] = distance[i];
        }
        Arrays.sort(robotData, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Sort walls
        int[] sortedWalls = walls.clone();
        Arrays.sort(sortedWalls);
        
        List<int[]> intervals = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int pos = robotData[i][0];
            int dist = robotData[i][1];
            
            int leftStart = pos - dist;
            int leftEnd = pos;
            
            int rightStart = pos;
            int rightEnd = pos + dist;
            
            // ✅ LEFT BLOCKING
            if (i > 0 && robotData[i - 1][0] >= leftStart) {
                leftStart = robotData[i - 1][0] + 1;
            }
            
            // ✅ RIGHT BLOCKING (IMPORTANT FIX)
            if (i < n - 1 && robotData[i + 1][0] <= rightEnd) {
                rightEnd = robotData[i + 1][0] - 1;
            }
            
            int leftCount = countWalls(sortedWalls, leftStart, leftEnd);
            int rightCount = countWalls(sortedWalls, rightStart, rightEnd);
            
            if (leftCount >= rightCount && leftStart <= leftEnd) {
                intervals.add(new int[]{leftStart, leftEnd});
            } else if (rightStart <= rightEnd) {
                intervals.add(new int[]{rightStart, rightEnd});
            }
        }
        
        if (intervals.isEmpty()) return 0;
        
        // Merge intervals
        intervals.sort((a, b) -> Integer.compare(a[0], b[0]));
        
        int total = 0;
        int currStart = intervals.get(0)[0];
        int currEnd = intervals.get(0)[1];
        
        for (int i = 1; i < intervals.size(); i++) {
            int[] interval = intervals.get(i);
            
            if (interval[0] <= currEnd) {
                currEnd = Math.max(currEnd, interval[1]);
            } else {
                total += countWalls(sortedWalls, currStart, currEnd);
                currStart = interval[0];
                currEnd = interval[1];
            }
        }
        
        total += countWalls(sortedWalls, currStart, currEnd);
        
        return total;
    }
    
    private int countWalls(int[] walls, int left, int right) {
        if (left > right) return 0;
        
        int start = lowerBound(walls, left);
        int end = upperBound(walls, right);
        
        return end - start;
    }
    
    private int lowerBound(int[] arr, int target) {
        int l = 0, h = arr.length;
        while (l < h) {
            int m = (l + h) / 2;
            if (arr[m] >= target) h = m;
            else l = m + 1;
        }
        return l;
    }
    
    private int upperBound(int[] arr, int target) {
        int l = 0, h = arr.length;
        while (l < h) {
            int m = (l + h) / 2;
            if (arr[m] > target) h = m;
            else l = m + 1;
        }
        return l;
    }
}