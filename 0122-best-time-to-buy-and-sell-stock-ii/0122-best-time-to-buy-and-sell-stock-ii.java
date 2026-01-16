class Solution {
    public int maxProfit(int[] prices) {
        int max = 0 , behind = 0 , ahead = 1;

        while(ahead < prices.length){
            max += prices[ahead] > prices[behind] ? (prices[ahead] - prices[behind]) : 0;
            behind++;
            ahead++;
        }
        return max;
    }
}