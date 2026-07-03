class Solution {
    String[] map = {
            " ",
            " ",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };

    List<String> ans;

    private void backtrack(String digits , int idx , StringBuilder sb){
        if(idx == digits.length()){
            ans.add(sb.toString());
            return;
        }

        String curr = map[digits.charAt(idx) - '0'];

        for(char ch : curr.toCharArray()){
            sb.append(ch);
            backtrack(digits , idx + 1 , sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        backtrack(digits , 0 , sb);

        return ans;
    }
}