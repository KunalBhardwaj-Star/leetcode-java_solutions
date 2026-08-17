class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        ans = []

        alph = [0] * 26

        for i in range(0 , len(s)):
            alph[ord(s[i]) - ord('a')] = i

        start = 0
        end = 0

        for i in range(0 , len(s)):
            end = max(end , alph[ord(s[i]) - ord('a')])

            if i == end :
                ans.append(end - start + 1)
                start = i+1
        

        return ans