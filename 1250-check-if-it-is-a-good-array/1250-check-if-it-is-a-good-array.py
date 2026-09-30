class Solution:
    def gcd(self , a: int , b: int) -> int:
        while b != 0:
            a , b = b , a % b

        return a


    def isGoodArray(self, nums: list[int]) -> bool:
        size = len(nums)        

        if size == 1 :
            return nums[0] == 1

        fact = gcd(nums[0] , nums[1])

        for i in range(2 , size):
            fact = gcd(fact , nums[i])

        return fact == 1