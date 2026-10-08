class Solution {
    public String removeOuterParentheses(String s) {
        int depth = -1;

        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == '('){
                depth++;
                stack.push('(');

                if(depth > 0){
                    sb.append('(');
                }
            }

            else{
                if(depth > 0)
                    sb.append(')');

                depth--;
                stack.pop();
            }
        }

        return sb.toString();
    }
}