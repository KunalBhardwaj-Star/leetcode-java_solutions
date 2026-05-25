class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int len = words.length;

        int[] count = new int[len];

        for(int i = 0 ; i < len ; i++){
            String curr = words[i];

            boolean vowel = (curr.charAt(0) == 'a' || curr.charAt(0) == 'e' || curr.charAt(0) == 'i' || curr.charAt(0) == 'o' || curr.charAt(0) == 'u') && (curr.charAt(curr.length() - 1) == 'a' || curr.charAt(curr.length() - 1) == 'e' || curr.charAt(curr.length() - 1) == 'i' || curr.charAt(curr.length() - 1) == 'o' || curr.charAt(curr.length() - 1) == 'u');

            if(vowel)
                count[i] = i == 0 ? 1 : count[i-1] + 1;

            else 
                count[i] = i == 0 ? 0 : count[i-1];
        }

        int[] ans = new int[queries.length];

        for(int i = 0 ; i < queries.length ; i++){
            int s = queries[i][0] , e = queries[i][1];

            if(s == 0)
                ans[i] = count[e];

            else 
                ans[i] = count[e] - count[s-1];
        }

        return ans;
    }
}