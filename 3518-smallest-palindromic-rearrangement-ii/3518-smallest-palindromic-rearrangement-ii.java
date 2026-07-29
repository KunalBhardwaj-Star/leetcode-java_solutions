class Solution {
    private long LIMIT = 1_000_001;
    private long count(int[] half , int halfLen){
        int remaining = halfLen;
        long ans = 1;

        for(int i = 0 ; i < 26 ; i++){
            
            long ways = combination(remaining , half[i]);

            if(ways != 0 && ans > LIMIT / ways)
                return LIMIT;

            ans *= ways;
            if(ans > LIMIT)
                return LIMIT;
            
            remaining -= half[i];
        }

        return ans;
    }

    private long combination(int n , int r){
        long ans = 1;

        for(int i = 1 ; i <= r; i++){
            ans *= (n - r + i);
            ans /= i;
        }

        return ans;
    }

    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];
        
        for(char ch : s.toCharArray())
            freq[ch - 'a']++;

        int[] half = new int[26];
        int halfLen = 0;
        String mid = "";

        for(int i = 0 ; i < 26 ; i++){
            if((freq[i] & 1) == 1)
                mid += (char)(i + 'a');

            half[i] = freq[i] / 2;
            halfLen += half[i];
        }

        StringBuilder firstHalf = new StringBuilder();

        for(int pos = 0 ; pos < halfLen ; pos++){
            for(int i = 0 ; i < 26 ; i++){
                if(half[i] == 0)
                    continue;

                half[i]--;

                long countWay = count(half , halfLen - pos - 1);

                if(k > countWay){
                    k -= countWay;
                    half[i]++;
                } else {
                    firstHalf.append((char)(i + 'a'));
                    break;
                }
            }
        }

        StringBuilder secondHalf = new StringBuilder(firstHalf).reverse();

        String ans = firstHalf.toString() + mid + secondHalf.toString();

        return ans.length() != s.length() ? "" : ans;
    }
}