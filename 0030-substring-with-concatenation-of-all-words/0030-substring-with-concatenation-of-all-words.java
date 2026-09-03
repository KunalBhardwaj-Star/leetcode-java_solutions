class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> ans = new ArrayList<>();

        int n = words.length;
        int size = words[0].length();

        HashMap<String, Integer> freq = new HashMap<>();

        for(String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        for(int offset = 0; offset < size; offset++) {

            int left = offset;
            int count = 0;

            HashMap<String, Integer> curr = new HashMap<>();

            for(int right = offset;
                right + size <= s.length();
                right += size) {

                String word = s.substring(right, right + size);

                if(!freq.containsKey(word)) {
                    curr.clear();
                    count = 0;
                    left = right + size;
                    continue;
                }

                curr.put(word,
                         curr.getOrDefault(word, 0) + 1);

                count++;

                while(curr.get(word) > freq.get(word)) {

                    String leftWord =
                        s.substring(left, left + size);

                    curr.put(leftWord,
                             curr.get(leftWord) - 1);

                    left += size;
                    count--;
                }

                if(count == n) {

                    ans.add(left);

                    String leftWord =
                        s.substring(left, left + size);

                    curr.put(leftWord,
                             curr.get(leftWord) - 1);

                    left += size;
                    count--;
                }
            }
        }

        return ans;
    }
}