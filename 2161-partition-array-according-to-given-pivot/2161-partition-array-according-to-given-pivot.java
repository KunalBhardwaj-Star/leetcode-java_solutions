class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int len = nums.length;

        int pivotCount = 0;
        ArrayList<Integer> leftPart = new ArrayList<>();
        ArrayList<Integer> rightPart = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            if (nums[i] < pivot)
                leftPart.add(nums[i]);
            else if (nums[i] > pivot)
                rightPart.add(nums[i]);
            else
                pivotCount++;
        }

        int idx = 0;

        for (idx = 0; idx < leftPart.size(); idx++)
            nums[idx] = leftPart.get(idx);

        for (int i = 0; i < pivotCount; i++)
            nums[idx++] = pivot;

        for (int i = 0; i < rightPart.size(); i++)
            nums[idx+i] = rightPart.get(i);

        return nums;
    }
}