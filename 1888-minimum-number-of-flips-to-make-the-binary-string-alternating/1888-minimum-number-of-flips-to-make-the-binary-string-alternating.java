class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String doubled = s + s;
        
        // Patterns to compare against
        char[] target1 = new char[2 * n];
        char[] target2 = new char[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            target1[i] = (i % 2 == 0) ? '0' : '1';
            target2[i] = (i % 2 == 0) ? '1' : '0';
        }

        int diff1 = 0, diff2 = 0;
        int res = Integer.MAX_VALUE;

        // Sliding Window
        for (int i = 0; i < 2 * n; i++) {
            if (doubled.charAt(i) != target1[i]) diff1++;
            if (doubled.charAt(i) != target2[i]) diff2++;

            if (i >= n) { // Slide the window: remove the element that left the window
                if (doubled.charAt(i - n) != target1[i - n]) diff1--;
                if (doubled.charAt(i - n) != target2[i - n]) diff2--;
            }

            if (i >= n - 1) { // Current window is of size n
                res = Math.min(res, Math.min(diff1, diff2));
            }
        }
        return res;
    }
}