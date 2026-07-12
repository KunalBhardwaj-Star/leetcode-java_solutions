class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] curr = arr.clone();

        Arrays.sort(arr);

        HashMap<Integer , Integer> map = new HashMap<>();

        int idx = 1;

        for(int i = 0 ; i < arr.length ; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i] , idx);
                idx++;
            }
                
        }

        int[] ans = new int[arr.length];
        for(int i = 0 ; i < arr.length ; i++){
            ans[i] = map.get(curr[i]);
        }

        return ans;
    }
}