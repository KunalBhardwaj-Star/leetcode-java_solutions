class Solution {
    public int longestBalanced(String s) {
        int len = s.length() , maxLen = 0;

        for(int i = 0; i < len ; i++){
            int size = 0,dist = 0;
            int[] alp = new int[26];

            for(int j = i ; j < len; j++){
                int max = 0 , min = Integer.MAX_VALUE;
                char ch = s.charAt(j);
                alp[ch - 'a'] += 1;
                if(alp[ch - 'a'] == 1) dist++;
                for(int count : alp){
                    if(count > 0){
                        max = Math.max(max , count);
                        min = Math.min(min , count);
                    }
                }
                if(max == min) maxLen = Math.max(maxLen , j-i+1);
            }
        }

        return maxLen;
    }
}