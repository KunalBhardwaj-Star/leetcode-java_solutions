class Solution {
    public String reverseVowels(String s) {
        char[] alph = s.toCharArray();

        int lft = 0 , rght = s.length() - 1;

        while(lft < rght){

            char l = Character.toLowerCase(alph[lft]);
            char r = Character.toLowerCase(alph[rght]);

            boolean lVowel = l == 'a' || l == 'e' || l == 'o' || l == 'u' || l == 'i';
            boolean rVowel = r == 'a' || r == 'e' || r == 'o' || r == 'u' || r == 'i';

            if(lVowel && rVowel){
                char curr = alph[lft];
                alph[lft] = alph[rght];
                alph[rght] = curr;

                lft++;
                rght--;
            } else if(lVowel && !rVowel)
                rght--;

            else if(!lVowel && rVowel)
                lft++;

            else{
                lft++;
                rght--;
            }
        }

        return new String(alph);
    }
}