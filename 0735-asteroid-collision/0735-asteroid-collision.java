import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> s = new Stack<>();
        s.push(asteroids[0]);

        for(int i = 1 ; i < asteroids.length ; i++){
            boolean flag = true;

            while(!s.isEmpty() && asteroids[i] < 0 && s.peek() > 0){
                if(asteroids[i] < 0){
                    if(Math.abs(asteroids[i]) > s.peek()){
                        s.pop();
                        continue;
                    }
                    else if(Math.abs(asteroids[i]) == s.peek()){
                        s.pop();
                        flag = false;
                        break;
                    } else {
                        flag = false;
                        break;
                    }
                } else {
                    s.push(asteroids[i]);
                }
            }

            if(flag){
               s.push(asteroids[i]); 
            }
        }

        int[] astCol = new int[s.size()];
        
        for(int i = s.size()-1 ; i >= 0 ; i--){
            astCol[i] = s.pop();
        }
        return astCol;
    }
}