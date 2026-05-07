class Solution {
    private boolean goodOrNot(int x) {
        boolean good = false;

        while (x != 0) {
            int curr = x % 10;

            if (curr == 3 || curr == 4 || curr == 7)
                return false;

            if (curr == 2 || curr == 5 || curr == 6 || curr == 9)
                good = true;

            x /= 10;
        }

        return good;
    }

    public int rotatedDigits(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (goodOrNot(i))
                count++;
        }

        return count;
    }
}