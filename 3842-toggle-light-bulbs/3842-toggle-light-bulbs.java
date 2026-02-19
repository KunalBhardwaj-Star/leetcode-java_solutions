class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        List<Integer> ans = new ArrayList<>();

        for(int i = 0 ; i < bulbs.size() ; i++){
            int curr = bulbs.get(i);

            if(ans.contains(curr)) ans.remove(Integer.valueOf(curr));
            else ans.add(curr);
        }

        Collections.sort(ans);

        return ans;
    }
}