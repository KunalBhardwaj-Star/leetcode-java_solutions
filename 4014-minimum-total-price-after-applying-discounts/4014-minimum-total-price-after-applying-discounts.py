class Solution:
    def minPrice(self, prices: list[int], discounts: list[int]) -> float:
        prices.sort(reverse = True)
        discounts.sort(reverse = True)

        ans = 0.0

        for i in range(0 , min(len(prices) , len(discounts))):
            ans += prices[i] * (100 - discounts[i]) / 100

        for i in range(len(discounts) , len(prices)):
            ans += prices[i]
        
        return ans