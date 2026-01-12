class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length , max = 0;
        int cheap = prices[0];

        for(int i = 1 ; i < n ; i++){
            if(prices[i] - cheap < 0){
                cheap = prices[i];
            } else{
                max = Math.max(prices[i] - cheap , max);
            }
        }
        return max;
    }
}