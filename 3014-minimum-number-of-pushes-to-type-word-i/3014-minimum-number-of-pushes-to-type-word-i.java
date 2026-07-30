class Solution {
    public int minimumPushes(String word) {
        int cost = 0;

        for(int i = 0 ; i < word.length() ; i++){
            cost += (i / 8) + 1;
        }

        return cost;
    }
}