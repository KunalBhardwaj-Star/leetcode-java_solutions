class Solution {
    public int compress(char[] chars) {
        int write = 0;
        int read = 0;

        while (read < chars.length) {

            char curr = chars[read];
            int count = 0;

            while (read < chars.length && chars[read] == curr) {
                count++;
                read++;
            }

            chars[write++] = curr;

            if (count > 1) {
                String s = String.valueOf(count);

                for (char ch : s.toCharArray()) {
                    chars[write++] = ch;
                }
            }
        }

        return write;
    }
}