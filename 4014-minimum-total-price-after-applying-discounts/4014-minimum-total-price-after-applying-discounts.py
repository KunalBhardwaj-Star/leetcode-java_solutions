class Solution:
    def minPrice(self, prices: list[int], discounts: list[int]) -> float:
        prices.sort()
        discounts.sort()

        p1 = len(prices) - 1
        p2 = len(discounts) - 1

        ans = 0.0

        while p1 >= 0 and p2 >= 0:
            dis = (100 - discounts[p2]) / 100
            ans += (prices[p1] * dis)
            p1 -= 1
            p2 -= 1

        while p1 >= 0:
            ans += prices[p1]
            p1 -= 1

        return ans
        