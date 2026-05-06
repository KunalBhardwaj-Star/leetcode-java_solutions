class Solution {
    private boolean goodNumOrNot(int n) {
        boolean good_int = false;

        int x = n;

        while (x != 0) {
            int curr = x % 10;
            if (curr == 3 || curr == 7 || curr == 4)
                return false;
            if (curr == 2 || curr == 5 || curr == 6 || curr == 9)
                good_int = true;

            x /= 10;
        }

        return good_int;
    }

    public int rotatedDigits(int n) {
        int count = 0;

        for(int i = 2 ; i <= n ; i++){
            if(goodNumOrNot(i)) count++;
        }

        return count;
    }
}