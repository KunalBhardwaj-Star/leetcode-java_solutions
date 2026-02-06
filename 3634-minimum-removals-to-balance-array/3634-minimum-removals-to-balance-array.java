class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        int answer = Integer.MAX_VALUE;
        int i = 0 , j = 1;
        while(i <= j && j < n){
            long min = (long)nums[i] , max = (long)nums[j];
            if(max <= (long)k * min){
                answer = Math.min(n - (j - i + 1) , answer);
                j++;
            }
            else i++;
        }

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}