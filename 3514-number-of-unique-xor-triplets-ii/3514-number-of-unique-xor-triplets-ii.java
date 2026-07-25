class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        if(n == 1)
            return 1;

        HashSet<Integer> pairXOR = new HashSet<>();

        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j < n ; j++){
                pairXOR.add(nums[i] ^ nums[j]);
            }
        }

        HashSet<Integer> ans = new HashSet<>();

        for(int x : pairXOR){
            for(int num : nums){
                ans.add(x ^ num);
            }
        }

        return ans.size();
    }
}