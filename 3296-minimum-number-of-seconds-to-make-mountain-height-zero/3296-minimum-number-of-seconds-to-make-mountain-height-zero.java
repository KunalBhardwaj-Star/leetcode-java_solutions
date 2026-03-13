class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long low = 1;
        
        long high = 1000000000000000000L; 
        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (canFinish(mid, mountainHeight, workerTimes)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1; 
            }
        }
        return ans;
    }

    private boolean canFinish(long timeLimit, int mountainHeight, int[] workerTimes) {
        long totalHeightReduced = 0;

        for (int t : workerTimes) {
            
            double val = (8.0 * timeLimit) / t;
            long x = (long) ((-1 + Math.sqrt(1 + val)) / 2);
            
            totalHeightReduced += x;

            if (totalHeightReduced >= mountainHeight) {
                return true;
            }
        }

        return totalHeightReduced >= mountainHeight;
    }
}