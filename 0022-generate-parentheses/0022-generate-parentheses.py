class Solution:

    def __init__(self):
        self.ans = []

    def backtrack(self , n: int , open_count: int , close_count: int , path):
        if (len(path) == 2 * n) and (open_count == close_count):
            self.ans.append("".join(path))
            return

        if open_count < n:
            path.append('(')
            self.backtrack(n , open_count + 1 , close_count , path)
            path.pop()

        if close_count < open_count:
            path.append(')')
            self.backtrack(n , open_count , close_count + 1 , path)
            path.pop()


    def generateParenthesis(self, n: int) -> List[str]:
        self.backtrack(n , 0 , 0 , [])
        return self.ans