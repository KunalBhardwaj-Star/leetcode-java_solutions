import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 1) return 1;
        ArrayList<Character> arr = new ArrayList<>();
        int count = 0 ;

        int i = 0 , j = 0 , curr = 0 ;
        while(i < n && j < n){
            if( !arr.contains(s.charAt(j))) {
                arr.add(s.charAt(j));
                j++;
                curr++;
            }
            else {
                arr.remove((Character) s.charAt(i));
                i++;
                curr-- ;
                
            }
            count = Math.max(count , curr);
        }
        return count;
    }
}