
class Solution {
    public int minOperations(String s) {
        int n = s.length();

        boolean sorted = true;
        char min = 'z';
        char max = 'a';
        int[] freq = new int[26];

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            min = (char) Math.min(min, c);
            max = (char) Math.max(max, c);
            freq[c - 'a']++;

            if (i > 0 && s.charAt(i) < s.charAt(i - 1)) {
                sorted = false;
            }
        }

        if (sorted) {
            return 0;
        }

        if (n == 2) {
            return -1;
        }

        char first = s.charAt(0);
        char last = s.charAt(n - 1);

        if (first == min || last == max) {
            return 1;
        }

        for (int i = 1; i < n - 1; i++) {
            char c = s.charAt(i);

            if (c == min || c == max) {
                return 2;
            }
        }

        if (freq[min - 'a'] > 1 || freq[max - 'a'] > 1) {
            return 2;
        }

        return 3;
    }
}
