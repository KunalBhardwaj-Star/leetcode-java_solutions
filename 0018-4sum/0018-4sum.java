class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n - 3; i++) {

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < n - 2; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                int lft = j + 1;
                int rght = n - 1;

                while (lft < rght) {

                    long sum = (long) nums[i]
                            + nums[j]
                            + nums[lft]
                            + nums[rght];

                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[lft], nums[rght]));
                        lft++;
                        rght--;

                        while (lft < rght && nums[lft] == nums[lft - 1])
                            lft++;

                        while (lft < rght && nums[rght] == nums[rght + 1])
                            rght--;
                    } else if (sum < target) {
                        lft++;
                    } else {
                        rght--;
                    }
                }
            }
        }

        return ans;
    }
}