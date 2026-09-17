class Solution {
    public int maxProfit(int[] prices) {
        int cheap = prices[0] , max = 0;

        for(int i = 1; i < prices.length ; i++){
            if(prices[i] - cheap < 0)
                cheap = prices[i];

            else
                max = Math.max(max , prices[i] - cheap);
        }

        return max;
    }
}