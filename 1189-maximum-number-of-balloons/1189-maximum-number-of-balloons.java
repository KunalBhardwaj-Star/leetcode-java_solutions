class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character , Integer>count = new HashMap<>();

        for(char ch : text.toCharArray()){
            count.put(ch , count.getOrDefault(ch , 0) + 1);
        }

        if(count.containsKey('b') && count.containsKey('a') && count.get('l') >= 2 && count.get('o') >= 2 && count.containsKey('n')){
            int a = Math.min(count.get('b') , Math.min(count.get('a') , Math.min(count.get('l')/2 , Math.min(count.get('o')/2 , count.get('n')))));
            return a;
        }
        return 0;
    }
}