import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> str = new Stack<>();
        for(int i =  0; i < s.length() ; i++){
            char ch = s.charAt(i);
            // opening
            if(ch == '(' || ch == '{' || ch == '['){
                str.push(ch);
            } else {
                //closing 
                if(str.isEmpty()){
                    return false;
                } 
                if((str.peek() == '(' && ch == ')') 
                || (str.peek() == '{' && ch == '}') 
                || (str.peek() == '[' && ch == ']')){
                    str.pop();
                } else {
                    return false;
                }
            }
        }
        if(!str.isEmpty()){
            return false;
        }
        else {
            return true;
        }
    }
}