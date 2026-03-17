import java.util.*;

class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> dQueue = new LinkedList<>();
        Queue<Integer> rQueue = new LinkedList<>();

        int len = senate.length();

        for(int i = 0 ; i < len ; i++){
            if(senate.charAt(i) == 'R') rQueue.add(i);
            else dQueue.add(i);
        }

        while(!rQueue.isEmpty() && !dQueue.isEmpty()){
            int rIdx = rQueue.poll() , dIdx = dQueue.poll();

            if(rIdx < dIdx) rQueue.add(rIdx + len);
            else dQueue.add(dIdx + len);
        }

        return rQueue.isEmpty() ? "Dire" : "Radiant";
    }
}