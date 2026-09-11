class Solution {
    public int totalNumbers(int[] digits) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int digit : digits) {
            map.put(digit, map.getOrDefault(digit, 0) + 1);
        }

        int ans = 0;

        for (int a = 1; a <= 9; a++) {          
            if (!map.containsKey(a)) continue;

            map.put(a, map.get(a) - 1);

            for (int b = 0; b <= 9; b++) {     
                if (!map.containsKey(b) || map.get(b) == 0) continue;

                map.put(b, map.get(b) - 1);

                for (int c = 0; c <= 8; c += 2) { 
                    if (!map.containsKey(c) || map.get(c) == 0) continue;

                    ans++;
                }

                map.put(b, map.get(b) + 1);
            }

            map.put(a, map.get(a) + 1);
        }

        return ans;
    }
}