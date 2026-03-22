class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int len = 10;

        ArrayList<String> ans = new ArrayList<>();

        if(s.length() < 10) return ans;

        Map<String, Integer> map = new LinkedHashMap<>();

        for(int i = 0 ; i <= s.length() - len ; i++){
           String currSub = s.substring(i , i + len);
           map.put(currSub , map.getOrDefault(currSub , 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() > 1) ans.add(entry.getKey());
        }

        return ans;
    }
}