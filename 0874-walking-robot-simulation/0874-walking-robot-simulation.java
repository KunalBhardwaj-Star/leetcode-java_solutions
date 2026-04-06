import java.util.*;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obs : obstacles) {
            obstacleSet.add(obs[0] + "," + obs[1]);
        }

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        int x = 0, y = 0, dir = 0; 
        int maxDistSq = 0;

        for (int cmd : commands) {
            if (cmd == -1) { 
                dir = (dir + 1) % 4;
            } else if (cmd == -2) { 
                dir = (dir + 3) % 4;
            } else { 
                for (int k = 0; k < cmd; k++) {
                    int nextX = x + directions[dir][0];
                    int nextY = y + directions[dir][1];
                    
                    if (!obstacleSet.contains(nextX + "," + nextY)) {
                        x = nextX;
                        y = nextY;
                        maxDistSq = Math.max(maxDistSq, x * x + y * y);
                    } else {
                        break;
                    }
                }
            }
        }
        
        return maxDistSq;
    }
}