class Solution {
    public int countDigitOne(int n) {
        int count = 0;

        for(long factor = 1 ; factor <= n ; factor *= 10){
            long higher = n / (factor * 10);
            long curr = (n / factor) % 10;
            long lower = n % factor;

            if (curr == 0)
                count += higher * factor;

            if (curr == 1)
                count += (higher * factor + lower + 1);

            if (curr > 1)
                count += (higher + 1) * factor;
        }

        return count;
    }
}