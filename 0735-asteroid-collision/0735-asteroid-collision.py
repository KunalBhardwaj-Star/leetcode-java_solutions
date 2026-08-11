class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        stack = []

        for i in range(0 , len(asteroids)):
            flag = True

            while len(stack) != 0 and asteroids[i] < 0 and stack[-1] > 0 :
                if abs(asteroids[i]) > stack[-1] : 
                    stack.pop()
                    continue

                elif abs(asteroids[i]) == stack[-1] :
                    stack.pop()
                    flag = False
                    break

                else :
                    flag = False
                    break

            if flag :
                stack.append(asteroids[i])

        return stack