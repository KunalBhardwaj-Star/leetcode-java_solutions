class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diff = new int[n + 1];

        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int dir = shift[2] == 1 ? 1 : -1;

            diff[start] += dir;
            if (end + 1 < n) diff[end + 1] -= dir;
        }

        StringBuilder res = new StringBuilder();
        int currShift = 0;

        for (int i = 0; i < n; i++) {
            currShift += diff[i];

            int original = s.charAt(i) - 'a';

            int newChar = (original + currShift) % 26;
            if (newChar < 0) newChar += 26;

            res.append((char) ('a' + newChar));
        }

        return res.toString();
    }
}