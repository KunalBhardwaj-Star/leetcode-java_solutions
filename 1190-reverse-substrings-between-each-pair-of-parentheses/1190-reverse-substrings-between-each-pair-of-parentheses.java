class Solution {

    public String reverseParentheses(String s) {
        int len = s.length();

        Stack<Integer> stack = new Stack<>(); //used for index of opening brackets

        StringBuilder ans = new StringBuilder();
        int idx = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(')
                stack.push(idx);

            else if (ch == ')') {
                int left = stack.pop();
                int right = Math.min(idx, ans.length() - 1);
                while (left < right) {
                    char temp = ans.charAt(left);
                    ans.setCharAt(left, ans.charAt(right));
                    ans.setCharAt(right, temp);
                    left++;
                    right--;
                }
            }

            else {
                ans.append(ch);
                idx++;
            }
        }

        return ans.toString();
    }
}