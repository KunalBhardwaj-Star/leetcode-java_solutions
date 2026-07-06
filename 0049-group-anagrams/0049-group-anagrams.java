class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String , ArrayList<String>> map = new HashMap<>();

        for(String curr : strs){
            char[] ch = curr.toCharArray();
            Arrays.sort(ch);
            String sorted = new String(ch);

            if(!map.containsKey(sorted)){
                ArrayList<String> list = new ArrayList<>();
                list.add(curr);
                map.put(sorted , list);
            } else{
                map.get(sorted).add(curr);
            }
        }

        List<List<String>> ans = new ArrayList<>();

        for(String Key : map.keySet()){
            ans.add(map.get(Key));
        }

        return ans;
    }
}