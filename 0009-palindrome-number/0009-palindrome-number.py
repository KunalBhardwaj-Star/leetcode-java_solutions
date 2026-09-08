class Solution:
    def isPalindrome(self, x: int) -> bool:
        s = str(x)

        lft , rght = 0 , len(s) - 1

        while(lft < rght) :
            if s[lft] != s[rght] :
                return False

            lft += 1
            rght -= 1

        return True

