class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];

        prefix[0] = nums[0];

        HashSet<Integer> set = new HashSet<>();

        set.add(nums[0]);

        for(int i = 1 ; i < n ; i++){
            prefix[i] = nums[i] + prefix[i-1];
            set.add(nums[i]);
        }

        int max = 0;

        for(int i = 1 ; i < n ; i++){
            if(nums[i] != nums[i-1] + 1){
                max = Math.max(max , prefix[i-1]);
                break;
            }
        }

        if(max == 0)
            max = prefix[n-1];

        for(int i = 0 ; i < set.size() ; i++){
            if(!set.contains(max))
                return max;

            max++;
        }

        return max;
    }
}