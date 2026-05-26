class Solution {
    public int numberOfSpecialChars(String word) {
        int len = word.length();
        boolean[] small = new boolean[26];
        boolean[] big = new boolean[26];

        for(int i = 0 ; i < len ; i++){
            char curr = word.charAt(i);

            if(curr >= 'a' && curr <= 'z')
                small[curr - 'a'] = true;
            else 
                big[curr - 'A'] = true;
        }

        int count = 0;

        for(int i = 0 ; i < 26 ; i++){
            if(big[i] && small[i])
                count++;
        }

        return count;
    }
}