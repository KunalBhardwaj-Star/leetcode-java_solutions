import java.util.*;

class Solution {
    public String removeStars(String s) {
        Stack<Character> ch = new Stack<>();
        
        int i = 0;
        while(i < s.length()){
            if(!ch.isEmpty() && s.charAt(i) == '*'){
                ch.pop();
            }else{
                ch.push(s.charAt(i));
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();
        while(!ch.isEmpty()){
            sb.append(ch.pop());
        }
        return sb.reverse().toString();
    }
}