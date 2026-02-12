import java.util.*;

class Solution {

    public int minimumDifference(int[] nums) {

        int n = nums.length;
        int half = n / 2;

        long totalSum = 0;
        for (int x : nums) totalSum += x;

        // Group sums by subset size
        List<Long>[] left = new ArrayList[half + 1];
        List<Long>[] right = new ArrayList[half + 1];

        for (int i = 0; i <= half; i++) {
            left[i] = new ArrayList<>();
            right[i] = new ArrayList<>();
        }

        // Generate left half subset sums
        for (int mask = 0; mask < (1 << half); mask++) {
            long sum = 0;
            int count = 0;

            for (int i = 0; i < half; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += nums[i];
                    count++;
                }
            }

            left[count].add(sum);
        }

        // Generate right half subset sums
        for (int mask = 0; mask < (1 << half); mask++) {
            long sum = 0;
            int count = 0;

            for (int i = 0; i < half; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += nums[i + half];
                    count++;
                }
            }

            right[count].add(sum);
        }

        // Sort all right lists for binary search
        for (int i = 0; i <= half; i++) {
            Collections.sort(right[i]);
        }

        long minDiff = Long.MAX_VALUE;

        // Try all possible sizes from left
        for (int k = 0; k <= half; k++) {

            List<Long> leftList = left[k];
            List<Long> rightList = right[half - k];

            for (long leftSum : leftList) {

                long target = totalSum / 2 - leftSum;

                int idx = Collections.binarySearch(rightList, target);

                if (idx >= 0) {
                    long currSum = leftSum + rightList.get(idx);
                    minDiff = Math.min(minDiff,
                            Math.abs(totalSum - 2 * currSum));
                } else {
                    int insertPos = -idx - 1;

                    if (insertPos < rightList.size()) {
                        long currSum = leftSum + rightList.get(insertPos);
                        minDiff = Math.min(minDiff,
                                Math.abs(totalSum - 2 * currSum));
                    }

                    if (insertPos - 1 >= 0) {
                        long currSum = leftSum + rightList.get(insertPos - 1);
                        minDiff = Math.min(minDiff,
                                Math.abs(totalSum - 2 * currSum));
                    }
                }
            }
        }

        return (int) minDiff;
    }
}
