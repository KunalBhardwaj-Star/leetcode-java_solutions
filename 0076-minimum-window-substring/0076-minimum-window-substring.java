class Solution {
    public String minWindow(String s, String t) {
        int m = s.length() , n = t.length();

        int lft = 0;
        int rght = 0;

        int[] need = new int[128];

        int required = 0;

        for(char ch : t.toCharArray()){
            if(need[ch] == 0){
                required++;
            }
            need[ch]++;
        }

        int[] wght = new int[128];

        int formed = 0;

        int min = Integer.MAX_VALUE;

        String ans = "";

        while(rght < m){
            char ch = s.charAt(rght);
            wght[ch]++;

            if(wght[ch] == need[ch])
                formed++;

            while(formed == required){
                if(min > rght - lft + 1){
                    ans = s.substring(lft , rght + 1);
                    min = Math.min(rght - lft + 1 , min);
                }

                char lftChar = s.charAt(lft);

                if(wght[lftChar] == need[lftChar])
                    formed--;

                wght[lftChar]--;

                lft++;
            }

            rght++;
        }

        return ans;
    }
}