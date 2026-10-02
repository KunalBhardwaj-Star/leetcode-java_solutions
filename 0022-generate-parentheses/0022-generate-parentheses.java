class Solution {
    List<String> ans;

    private void backtrack(StringBuilder curr , int n , int openCount , int closeCount){
        if(curr.length() == 2 * n && openCount == closeCount){
            String s = curr.toString();
            ans.add(s);
            return;
        }

        if(openCount < n){
            curr.append('(');
            backtrack(curr , n , openCount + 1 , closeCount);
            curr.deleteCharAt(curr.length() - 1);
        }

        if(closeCount < openCount){
            curr.append(')');
            backtrack(curr , n , openCount , closeCount + 1);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        backtrack(new StringBuilder() , n , 0 , 0);
        return ans;
    }
}