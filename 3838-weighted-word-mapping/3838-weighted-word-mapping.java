class Solution {
    private int summation(String curr , int[] wgt){
        int sum = 0;

        for(char ch : curr.toCharArray())
            sum += wgt[ch - 'a'];

        return sum % 26;
    }
    public String mapWordWeights(String[] words, int[] weights) {
        String ans = "";

        for(String s : words){
            int currSum = summation(s , weights);

            ans += (char)('a' + (25 - currSum));
        }

        return ans;
    }
}