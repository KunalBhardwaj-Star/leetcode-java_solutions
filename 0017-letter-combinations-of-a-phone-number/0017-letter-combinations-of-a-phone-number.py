class Solution:

    def __init__(self):
        self.ans = []
        self.mp = {
            "2": "abc",
            "3": "def",
            "4": "ghi",
            "5": "jkl",
            "6": "mno",
            "7": "pqrs",
            "8": "tuv",
            "9": "wxyz"
        }

    def letterCombinations(self, digits: str) -> List[str]:

        if not digits:
            return []

        def backtrack(idx , path):
            if len(path) == len(digits):
                self.ans.append("".join(path))
                return

            for ch in self.mp[digits[idx]]:
                path.append(ch)
                backtrack(idx + 1 , path)
                path.pop()

        backtrack(0 , [])
        return self.ans
