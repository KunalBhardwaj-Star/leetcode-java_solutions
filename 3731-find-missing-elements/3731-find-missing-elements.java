class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        // boolean[] present = new boolean[n+1];

        // for(int x : nums)
        //     present[x - 1] = true;

        int min = 100 , max = 1;

        int lft = 0 , rght = n - 1;

        HashSet<Integer> set = new HashSet<>();

        while(lft <= rght){
            set.add(nums[lft]);
            set.add(nums[rght]);
            min = Math.min(min , Math.min(nums[lft] , nums[rght]));
            max = Math.max(max , Math.max(nums[lft] , nums[rght]));
            lft++;
            rght--;
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = min ; i <= max ; i++){

            if(!set.contains(i))
                ans.add(i);
        }

        return ans;
    }
}