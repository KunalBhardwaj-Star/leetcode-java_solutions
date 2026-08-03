class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();

        String mid = "";

        int[] alph = new int[26];

        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            alph[ch - 'a']++;
        }

        int[] half = new int[26];

        for(int i = 0 ; i < 26 ; i++){
            if(alph[i] % 2 != 0)
                mid += "" + (char)(i + 'a');

            half[i] = alph[i] / 2;
        }

        StringBuilder firstHalf = new StringBuilder();

        for(int i = 0 ; i < 26 ; i++){
            while(half[i] != 0){
                firstHalf.append((char)(i + 'a'));
                half[i]--;
            }
        }

        StringBuilder secondHalf = new StringBuilder(firstHalf).reverse();

        return firstHalf.toString() + mid + secondHalf.toString();
    }
}