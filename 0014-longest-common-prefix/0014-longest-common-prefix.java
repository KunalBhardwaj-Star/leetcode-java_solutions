class Solution {
    private String commonPrefix(String s1 , String s2){
        int i = 0;

        while(i < s1.length() && i < s2.length() && s1.charAt(i) == s2.charAt(i))
            i++;

        return s1.substring(0 , i);
    }
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        String s1 = strs[0];

        if(len == 1)
            return s1;

        for(int i = 1 ; i < len ; i++){
            String s2 = strs[i];

            s1 = commonPrefix(s1 , s2);
        }

        return s1;
    }
}