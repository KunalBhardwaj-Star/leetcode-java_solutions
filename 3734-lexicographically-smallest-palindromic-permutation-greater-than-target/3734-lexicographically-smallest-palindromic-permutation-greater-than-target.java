class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int odd = 0;
        char middle = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                odd++;
                middle = (char) ('a' + i);
            }
        }

        if (odd > 1) {
            return "";
        }

        int halfLen = n / 2;
        int[] halfFreq = new int[26];

        for (int i = 0; i < 26; i++) {
            halfFreq[i] = freq[i] / 2;
        }

        char[] targetHalf = target.substring(0, halfLen).toCharArray();

        char[] half = new char[halfLen];

        for (int i = 0; i < halfLen; i++) {
            half[i] = targetHalf[i];
        }

        int[] available = halfFreq.clone();

        for (char c : half) {
            if (available[c - 'a'] == 0) {
                return findGreater(halfFreq, target, middle, n);
            }
            available[c - 'a']--;
        }

        String candidate = build(half, middle, n);

        if (candidate.compareTo(target) > 0) {
            return candidate;
        }

        return findGreater(halfFreq, target, middle, n);
    }

    private String findGreater(int[] freq, String target, char middle, int n) {
        int halfLen = n / 2;
        char[] targetHalf = target.substring(0, halfLen).toCharArray();

        for (int i = halfLen - 1; i >= 0; i--) {
            int[] remaining = freq.clone();

            for (int j = 0; j < i; j++) {
                remaining[targetHalf[j] - 'a']--;

                if (remaining[targetHalf[j] - 'a'] < 0) {
                    break;
                }
            }

            if (i > 0) {
                boolean possible = true;

                int[] check = freq.clone();

                for (int j = 0; j < i; j++) {
                    int c = targetHalf[j] - 'a';

                    if (check[c] == 0) {
                        possible = false;
                        break;
                    }

                    check[c]--;
                }

                if (!possible) {
                    continue;
                }

                remaining = check;
            }

            int current = targetHalf[i] - 'a';

            for (int c = current + 1; c < 26; c++) {
                if (remaining[c] > 0) {
                    char[] result = new char[halfLen];

                    for (int j = 0; j < i; j++) {
                        result[j] = targetHalf[j];
                    }

                    result[i] = (char) ('a' + c);

                    remaining[c]--;

                    int pos = i + 1;

                    for (int x = 0; x < 26; x++) {
                        while (remaining[x] > 0) {
                            result[pos++] = (char) ('a' + x);
                            remaining[x]--;
                        }
                    }

                    String answer = build(result, middle, n);

                    if (answer.compareTo(target) > 0) {
                        return answer;
                    }
                }
            }
        }

        return "";
    }

    private String build(char[] half, char middle, int n) {
        StringBuilder sb = new StringBuilder();

        for (char c : half) {
            sb.append(c);
        }

        if (n % 2 == 1) {
            sb.append(middle);
        }

        for (int i = half.length - 1; i >= 0; i--) {
            sb.append(half[i]);
        }

        return sb.toString();
    }
}