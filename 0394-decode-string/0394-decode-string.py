class Solution:
    def decodeString(self, s: str) -> str:
        stack = []

        for c in s:
            if c != ']':
                stack.append(c)

            else :
                subs = ""
                while stack[-1] != '[':
                    subs += stack.pop()
                stack.pop()

                nums = ""

                while stack and stack[-1].isdigit():
                    nums += stack.pop()

                ns = int(nums[::-1]) * subs[::-1]

                stack.extend(ns)

        return ''.join(stack)