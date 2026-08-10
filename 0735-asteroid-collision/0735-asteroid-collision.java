class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();

        s.push(asteroids[0]);

        int n = asteroids.length;

        for(int i = 1; i < n ; i++){
            boolean flag = true;

            while(!s.isEmpty() && asteroids[i] < 0 && s.peek() > 0){
                if(Math.abs(asteroids[i]) > s.peek()){
                    s.pop();
                    continue;
                } else if(Math.abs(asteroids[i]) == s.peek()){
                    s.pop();
                    flag = false;
                    break;
                } else{
                    flag = false;
                    break;
                }
            }

            if(flag){
                s.push(asteroids[i]);
            }
        }

        int[] ans = new int[s.size()];

        for(int i = ans.length - 1 ; i >= 0 ; i--){
            ans[i] = s.pop();
        }

        return ans;
    }
}