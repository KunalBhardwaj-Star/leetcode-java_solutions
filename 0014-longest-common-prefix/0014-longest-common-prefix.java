class Solution {

    private String compare(String s1 , String s2){
        int p1 = 0 , p2 = 0;

        while(p1 < s1.length() && p2 < s2.length() && s1.charAt(p1) == s2.charAt(p2)){
            p1++;
            p2++;
        }

        return s1.substring(0 , p1);
    }

    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;

        if(n == 1)
            return strs[0];

        String ans = strs[0];

        for(int i = 1 ; i < n ; i++){
            String s1 = strs[i];

            ans = compare(ans , s1);
        }

        return ans;
    }
}