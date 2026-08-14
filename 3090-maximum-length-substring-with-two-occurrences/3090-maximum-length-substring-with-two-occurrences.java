class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character , Integer> map = new HashMap<>();

        int lft = 0;

        int max = 0;

        for(int rght = 0 ; rght < s.length() ; rght++){
            char ch = s.charAt(rght);

            map.put(ch , map.getOrDefault(ch , 0) + 1);

            while(map.get(ch) > 2){
                char left = s.charAt(lft);

                map.put(left , map.get(left) - 1);

                if(map.get(left) == 0)
                    map.remove(left);

                lft++;
            }

            max = Math.max(max , rght - lft + 1);
        }

        return max;
    }
}