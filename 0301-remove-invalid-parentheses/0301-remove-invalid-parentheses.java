class Solution {
    List<String> answer = new ArrayList<>();
    HashSet<String> set = new HashSet<>();

    private void dfs(String s, int idx , int removeOpen , int removeClose , int openCount , int closeCount , StringBuilder sb){
        if(idx == s.length()){
            if(removeOpen == 0 && removeClose == 0 && closeCount == openCount)
                set.add(sb.toString());
            return;
        }

        char ch = s.charAt(idx);

        if(ch >= 'a' && ch <= 'z'){
            sb.append(ch);
            dfs(s , idx + 1, removeOpen , removeClose , openCount , closeCount , sb);
            sb.deleteCharAt(sb.length()-1);
        }

        if(ch == '('){
            if(removeOpen > 0)
                dfs(s , idx + 1, removeOpen - 1 , removeClose , openCount , closeCount , sb);

            sb.append('(');
            dfs(s , idx + 1, removeOpen , removeClose , openCount + 1 , closeCount , sb);
            sb.deleteCharAt(sb.length()-1);
        }

        else{
            if(removeClose > 0)
                dfs(s , idx + 1, removeOpen , removeClose - 1 , openCount , closeCount , sb);

            if(openCount > closeCount){
                sb.append(')');
                dfs(s , idx + 1, removeOpen , removeClose , openCount , closeCount + 1, sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        int removeOpen = 0 , removeClose = 0;

        for(char ch : s.toCharArray()){
            if(ch == '(')
                removeOpen++;

            else if(ch == ')'){
                if(removeOpen > 0)
                    removeOpen--;

                else
                    removeClose++;
            }
        }

        dfs(s , 0 , removeOpen , removeClose , 0 , 0 , new StringBuilder());

        for(String x : set){
            answer.add(x);
        }

        return answer;
    }
}