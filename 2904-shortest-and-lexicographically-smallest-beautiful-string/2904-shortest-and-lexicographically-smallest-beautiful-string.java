class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int lft = 0 , ones = 0;

        String ans = "";

        for(int rght = 0 ; rght < n ; rght++){

            if(s.charAt(rght) == '1')
                ones++;

            while(ones > k){
                if(s.charAt(lft) == '1')
                    ones--;
                lft++;
            }

            if(ones == k){
                while(s.charAt(lft) == '0')
                    lft++;

                String curr = s.substring(lft , rght + 1);

                if(ans.equals("") || ans.length() > curr.length() || (ans.length() == curr.length() && curr.compareTo(ans) < 0))
                    ans = curr;
            }
        }

        return ans;
    }
}