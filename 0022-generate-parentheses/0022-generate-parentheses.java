class Solution {
    List<String> ans;

    private void backtrack(int n , int openCount , int closeCount , StringBuilder sb){
        if((sb.length() == 2 * n) && (closeCount == openCount)){
            ans.add(sb.toString());
            return;
        }

        if(openCount < n){
            sb.append("(");
            backtrack(n , openCount + 1 , closeCount , sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(closeCount < openCount){
            sb.append(")");
            backtrack(n , openCount , closeCount + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        backtrack(n , 0 , 0 , new StringBuilder());
        return ans;
    }
}