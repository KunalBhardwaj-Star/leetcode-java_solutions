class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        List<String> ans = new ArrayList<>();

        int[] start = new int[26];
        int[] end = new int[26];

        Arrays.fill(start, -1);

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';

            if (start[c] == -1) {
                start[c] = i;
            }

            end[c] = i;
        }

        boolean[] valid = new boolean[26];
        Arrays.fill(valid, true);

        for (int c = 0; c < 26; c++) {

            if (start[c] == -1)
                continue;

            for (int i = start[c]; i <= end[c]; i++) {

                int curr = s.charAt(i) - 'a';

                if (start[curr] < start[c]) {
                    valid[c] = false;
                    break;
                }

                end[c] = Math.max(end[c], end[curr]);
            }
        }

        int lastTaken = s.length();

        for (int i = s.length() - 1; i >= 0; i--) {

            int c = s.charAt(i) - 'a';

            if (i != start[c] || !valid[c])
                continue;

            if (end[c] < lastTaken) {
                ans.add(s.substring(i, end[c] + 1));
                lastTaken = i;
            }
        }

        return ans;
    }
}