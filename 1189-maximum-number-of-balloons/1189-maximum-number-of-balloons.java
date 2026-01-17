class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character , Integer>count = new HashMap<>();
        String target = "balloon";
        int sum = Integer.MAX_VALUE , len = text.length();
        for(int i = 0 ; i < len; i++){
            char ch = text.charAt(i);

            if(target.indexOf(ch) != -1) {
                count.put(ch , count.getOrDefault(ch,0) + 1);
            }
        }
        
        for(int i = 0 ; i < 7 ; i++){
            char curr = target.charAt(i);
            if(!count.containsKey(curr) || (curr == 'l' && count.get(curr) < 2) || (curr == 'o' && count.get(curr) < 2)) return 0;
            if(curr == 'l' || curr == 'o')sum = Math.min(sum , count.get(curr)/2);
            else sum = Math.min(sum , count.get(curr));
        }
        return sum;
    }
}