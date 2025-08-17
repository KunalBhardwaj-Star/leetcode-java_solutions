import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer , Integer> map = new HashMap<>();
        ArrayList<Integer> AL = new ArrayList<>();

        for(int i = 0 ; i < nums.length ; i++){
            map.put(nums[i] , map.getOrDefault(nums[i] , 0) + 1);
        }

        Set<Integer> keySet = map.keySet();
        for(Integer key : keySet){
            if(map.get(key) > nums.length/3){
                AL.add(key);
            }
        }

        return AL;
    }
}