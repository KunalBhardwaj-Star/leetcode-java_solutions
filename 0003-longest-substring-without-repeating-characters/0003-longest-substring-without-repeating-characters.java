class Solution {
    public int lengthOfLongestSubstring(String s) {
        int lft = 0;
        int[] count = new int[128];

        int len = 0 ;

        for(int rght = 0 ; rght < s.length() ; rght++){
            char curr = s.charAt(rght);
            count[curr]++;

            while(count[curr] > 1){
                count[s.charAt(lft)]--;
                lft++;
            }

            len = Math.max(rght - lft + 1 , len);
        }

        return len;
    }
}