import java.util.*;

class Solution {
    static class Point {
        int pos, x, y;

        Point(int pos, int x, int y) {
            this.pos = pos;
            this.x = x;
            this.y = y;
        }
    }

    public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        int perimeter = 4 * side;

        List<Point> list = new ArrayList<>();

        for (int[] p : points) {
            int x = p[0], y = p[1];
            int pos;

            if (y == 0) pos = x;
            else if (x == side) pos = side + y;
            else if (y == side) pos = 3 * side - x;
            else pos = 4 * side - y;

            list.add(new Point(pos, x, y));
        }

        list.sort(Comparator.comparingInt(a -> a.pos));

        Point[] arr = new Point[2 * n];
        for (int i = 0; i < n; i++) {
            Point p = list.get(i);
            arr[i] = p;
            arr[i + n] = new Point(p.pos + perimeter, p.x, p.y);
        }

        int low = 0, high = 2 * side, ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            boolean possible = false;
            
            for (int start = 0; start < n && !possible; start++) {
                int currentIdx = start;
                boolean valid = true;
                
                for (int selected = 1; selected < k; selected++) {
                    int left = currentIdx + 1, right = start + n - 1;
                    int nextIdx = -1;
                    
                    while (left <= right) {
                        int midIdx = left + (right - left) / 2;
                        int d = Math.abs(arr[midIdx].x - arr[currentIdx].x) +
                               Math.abs(arr[midIdx].y - arr[currentIdx].y);
                        
                        if (d >= mid) {
                            nextIdx = midIdx;
                            right = midIdx - 1;
                        } else {
                            left = midIdx + 1;
                        }
                    }
                    
                    if (nextIdx == -1) {
                        valid = false;
                        break;
                    }
                    currentIdx = nextIdx;
                }
                
                if (valid) {
                    int wrapDist = Math.abs(arr[currentIdx].x - arr[start].x) +
                                  Math.abs(arr[currentIdx].y - arr[start].y);
                    if (wrapDist >= mid) {
                        possible = true;
                    }
                }
            }
            
            if (possible) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}