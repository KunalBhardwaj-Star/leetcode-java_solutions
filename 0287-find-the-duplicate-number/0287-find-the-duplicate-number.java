class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        if(n == 2)
            return nums[0];

        int pnt1 = 0 , pnt2 = 1;

        while(pnt1 < n && pnt2 < n){
            if(nums[pnt1] == nums[pnt2])
                return nums[pnt1];

            pnt1++;
            pnt2++;
        }

        return -1;
    }
}