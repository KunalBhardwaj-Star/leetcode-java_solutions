class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();

        int lft = 0;

        int count = 0;

        int max = 0;

        for(int rght = 0 ; rght < n ; rght++){
            char curr = s.charAt(rght);

            if(curr == 'a' || curr == 'e' || curr == 'i' || curr == 'o' || curr == 'u')
                count++;

            if(rght - lft + 1 == k){
                max = Math.max(max , count);
                if(s.charAt(lft) == 'a' || s.charAt(lft) == 'e' || s.charAt(lft) == 'i' || s.charAt(lft) == 'o' || s.charAt(lft) == 'u')
                    count--;
                
                lft++;
            }
        }

        return max;
    }
}