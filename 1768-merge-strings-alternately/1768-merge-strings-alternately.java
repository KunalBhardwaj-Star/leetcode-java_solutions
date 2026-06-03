class Solution {
    public String mergeAlternately(String word1, String word2) {
        int p1 = 0 , p2 = 0;
        String ans = "";

        while(p1 < word1.length() && p2 < word2.length()){
            ans += word1.charAt(p1);
            ans+= word2.charAt(p2);

            p1++;
            p2++;
        }

        ans += word1.substring(p1 , word1.length());
        ans += word2.substring(p2 , word2.length());

        return ans;
    }
}