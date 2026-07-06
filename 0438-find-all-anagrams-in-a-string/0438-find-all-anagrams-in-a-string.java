class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        int len1 = s.length();
        int len2 = p.length();

        char[] ch = p.toCharArray();
        Arrays.sort(ch);
        p = new String(ch);

        int count = 0;

        for(int i = 0 ; i <= len1 - len2 ; i++){
            String curr = s.substring(i , i + len2);
            char[] c = curr.toCharArray();
            Arrays.sort(c);
            curr = new String(c);

            if(curr.equals(p))
                ans.add(i);
        }

        return ans;
    }
}