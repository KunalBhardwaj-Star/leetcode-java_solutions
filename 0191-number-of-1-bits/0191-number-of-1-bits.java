class Solution {
    public int hammingWeight(int n) {
        int count1S = 0;

        while(n != 0){
            n = n & (n-1);

            count1S++;
        }

        return count1S;
    }
}