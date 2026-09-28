class Solution {
    public int maxDepth(String s) {
        int len = s.length();

        int lft = 0;
        int rght = 0;

        int max = 0;

        for(char ch : s.toCharArray()){
            if(ch == '(')
                lft++;
            
            else if(ch == ')')
                rght++;
            
            
            max = Math.max(max , lft - rght);
        }

        return max;
    }
}