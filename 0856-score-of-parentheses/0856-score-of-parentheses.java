class Solution {
    public int scoreOfParentheses(String s) {
        int len = s.length();

        if(len == 2)
            return 1;

        int score = 0;

        Stack<Character> stack = new Stack<>();

        int d = 0;

        int idx = 0;

        while(idx < len){
            char ch = s.charAt(idx);

            if(ch == '('){
                stack.push('(');
                d++;
                idx++;
            }

            else{
                score += (int)(Math.pow(2 , d - 1));
                while(!stack.isEmpty() && s.charAt(idx) == ')'){
                    stack.pop();
                    d--;
                    idx++;
                }
            }
        }

        return score;
    }
}