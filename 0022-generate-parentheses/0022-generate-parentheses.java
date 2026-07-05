class Solution {
    List<String> ans;
    private void backtrack(int n , StringBuilder sb , int openCount , int closeCount){
        if((sb.length() == 2 * n) && (openCount == closeCount)){
            ans.add(sb.toString());
            return;
        }

        //opening parenthesis
        if(openCount < n){
            sb.append("(");
            backtrack(n , sb , openCount+1 , closeCount);
            sb.deleteCharAt(sb.length() - 1);
        }

        //closing parenthesis
        if(closeCount < openCount){
            sb.append(")");
            backtrack(n , sb , openCount , closeCount+1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        backtrack(n , new StringBuilder() , 0 , 0);
        return ans;
    }
}