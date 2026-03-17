class Solution {
    public String reverseWords(String s) {
        int len = s.length();

        String[] words = s.trim().split("\\s+");

        StringBuilder ans = new StringBuilder();

        for(int k = words.length - 1; k >= 0 ; k--){
            if(k > 0)ans.append(words[k] + " ");
            else ans.append(words[k]);
        }

        return ans.toString();
    }
}