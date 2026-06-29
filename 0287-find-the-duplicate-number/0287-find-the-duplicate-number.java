class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;

        HashMap<Integer , Integer> hm = new HashMap<>();

        for(int x : nums){
            hm.put(x, hm.getOrDefault(x, 0) + 1);
        }

        for(int key : hm.keySet()){
            int freq = hm.get(key);
            if(freq > 1)
                return key;
        }

        return -1;
    }
}