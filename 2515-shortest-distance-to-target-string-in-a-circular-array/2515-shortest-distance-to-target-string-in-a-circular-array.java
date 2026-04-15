class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        if(words[startIndex].equals(target)) return 0;

        int len = words.length;

        int ans = Integer.MAX_VALUE ;

        for(int i = 0 ; i < len ; i++){
            if(words[i].equals(target)){
               int diff = Math.abs(i - startIndex);
                int dist = Math.min(diff, len - diff);
                ans = Math.min(ans, dist);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}