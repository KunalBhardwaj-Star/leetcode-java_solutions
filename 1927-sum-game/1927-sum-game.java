class Solution {
    public boolean sumGame(String num) {
        int lftSum = 0 , rghtSum = 0 , lftQ = 0 , rghtQ = 0;
        int n = num.length();

        for(int i = 0 ; i < n / 2 ; i++){
            if(num.charAt(i) == '?')
                lftQ++;
            else 
                lftSum += (num.charAt(i) - '0');

            if(num.charAt(n - i - 1) == '?')
                rghtQ++;
            else 
                rghtSum += (num.charAt(n - i - 1) - '0');
        }

        int diff = lftSum - rghtSum;

        return diff * 2 + (lftQ - rghtQ) * 9 != 0;
    }
}