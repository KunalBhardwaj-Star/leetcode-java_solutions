class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        x , y = len(haystack) , len(needle)

        for i in range(0 , x):

            if i + y > x:
                return -1

            if(haystack[i : i + y] == needle):
                return i


        return -1
        