class Solution {
    public String smallestPalindrome(String s) {
        int len = s.length();

        int[] alph = new int[26];

        for(int i = 0 ; i < len ; i++)
            alph[s.charAt(i) - 'a']++;

        StringBuilder firstPart = new StringBuilder();
        String mid = "";

        for(int i = 0 ; i < 26 ; i++){
            int half = alph[i] / 2;

            for(int j = 0; j < half ; j++){
                firstPart.append((char)(i + 'a'));
            }

            alph[i] %= 2;

            if(alph[i] == 1)
                mid += (char)(i + 'a');
        }

        return firstPart.toString() + mid + firstPart.reverse().toString();
    }
}