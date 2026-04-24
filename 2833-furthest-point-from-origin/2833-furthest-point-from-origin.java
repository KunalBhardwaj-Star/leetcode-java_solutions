class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int l_count = 0 , r_count = 0 , b_count = 0;
        int len = moves.length();

        for(int i = 0 ; i < len ; i ++){
            char ch = moves.charAt(i);

            if(ch == 'L') l_count++;
            else if(ch == 'R') r_count++;
            else b_count++;
        }

        return Math.abs(l_count - r_count) + b_count;
    }
}