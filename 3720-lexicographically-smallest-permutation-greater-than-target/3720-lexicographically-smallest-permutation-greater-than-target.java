import java.util.*;

class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();

        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int lastPos = -1;
        int[] lastFreq = null;

        for (int i = 0; i < n; i++) {
            int t = target.charAt(i) - 'a';

            for (int c = t + 1; c < 26; c++) {
                if (freq[c] > 0) {
                    lastPos = i;
                    lastFreq = freq.clone();
                    break;
                }
            }

            if (freq[t] == 0) {
                break;
            }

            freq[t]--;
        }

        if (lastPos == -1) {
            return "";
        }

        StringBuilder ans = new StringBuilder();

        ans.append(target.substring(0, lastPos));

        freq = lastFreq.clone();

        int t = target.charAt(lastPos) - 'a';

        int chosen = -1;
        for (int c = t + 1; c < 26; c++) {
            if (freq[c] > 0) {
                chosen = c;
                break;
            }
        }

        if (chosen == -1) {
            return "";
        }

        ans.append((char)('a' + chosen));
        freq[chosen]--;

        for (int c = 0; c < 26; c++) {
            while (freq[c] > 0) {
                ans.append((char)('a' + c));
                freq[c]--;
            }
        }

        return ans.toString();
    }
}