class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        int len = s.length();

        if(s.charAt(0) == ')' || s.charAt(0) == '}' || s.charAt(0) == ']')
            return false;

        if(s.charAt(len - 1) == '(' || s.charAt(len - 1) == '{' || s.charAt(len - 1) == '[')
            return false;

        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '[')
                stack.push(ch);

            else{

                if(stack.isEmpty())
                    return false;

                if((stack.peek() == '(' && ch == ')') || (stack.peek() == '{' && ch == '}') || (stack.peek() == '[' && ch == ']'))
                    stack.pop();

                else
                    stack.push(ch);
            }
        }

        return stack.size() == 0;
    }
}