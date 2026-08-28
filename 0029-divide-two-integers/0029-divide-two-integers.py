class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        INT_MIN = -(1 << 31)
        INT_MAX = (1 << 31) - 1

        if dividend == INT_MIN and divisor == -1:
            return INT_MAX

        negative = (dividend < 0) != (divisor < 0)

        dividend = abs(dividend)
        divisor = abs(divisor)

        quotient = 0

        while dividend >= divisor:
            shift = 0

            while dividend >= (divisor << (shift + 1)):
                shift += 1

            quotient += (1 << shift)
            dividend -= (divisor << shift)

        return -quotient if negative else quotient