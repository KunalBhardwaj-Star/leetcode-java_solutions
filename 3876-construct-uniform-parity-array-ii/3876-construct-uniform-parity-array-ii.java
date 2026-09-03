class Solution {
    public boolean uniformArray(int[] nums1) {

        int minVal = Integer.MAX_VALUE;

        for(int x : nums1)
            minVal = Math.min(x , minVal);

        boolean odd = minVal % 2 != 0;

        for(int x : nums1){
            if(!odd && x % 2 != 0){
                return false;
            }
        }

        return true;
    }
}