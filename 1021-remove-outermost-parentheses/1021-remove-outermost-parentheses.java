class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Integer> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()){
            if(ch == '('){
                int depth = stack.isEmpty() ? -1 : stack.peek();
                if(depth + 1 > 0)
                    sb.append('(');

                stack.push(depth + 1);
            }
            else{
                int depth = stack.pop();
                if(depth > 0)
                    sb.append(')');
            }
        }

        return sb.toString();
    }
}