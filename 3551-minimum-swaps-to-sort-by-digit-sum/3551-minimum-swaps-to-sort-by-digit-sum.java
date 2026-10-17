
import java.util.*;

class Solution {

    private int digitSum(int n) {
        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = digitSum(nums[i]);
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }

            return Integer.compare(a[0], b[0]);
        });

        Map<Integer, Integer> targetIndex = new HashMap<>();

        for (int i = 0; i < n; i++) {
            targetIndex.put(arr[i][0], i);
        }

        int swaps = 0;

        for (int i = 0; i < n; i++) {
            while (nums[i] != arr[i][0]) {
                int correctIndex = targetIndex.get(nums[i]);

                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;

                swaps++;
            }
        }

        return swaps;
    }
}
