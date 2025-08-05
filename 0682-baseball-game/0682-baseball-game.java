import java.util.*;

class Solution {
    public int calPoints(String[] operations) {
        int sumOfScoreLine = 0;
        Stack <Integer> scoreLine = new Stack<>();
        int i = 0;
        while(i < operations.length ){
            if ((!operations[i].equals("D"))
                    && (!operations[i].equals("C"))
                    && (!operations[i].equals("+"))){
                scoreLine.push(Integer.parseInt(operations[i]));
            } else {
                if (operations[i].equals("D")){
                    if (!scoreLine.isEmpty()){
                        scoreLine.push(2 * scoreLine.peek() );
                    } else {
                        scoreLine.push(0);
                    }
                }
                if (operations[i].equals("C")){
                    if (!scoreLine.isEmpty()){
                        scoreLine.pop();
                    } else {
                        scoreLine.push(0);
                    }
                }
                if (operations[i].equals("+")){
                    if (scoreLine.size() >= 2){
                        int top = scoreLine.get(scoreLine.size() - 1);
                        int second = scoreLine.get(scoreLine.size() - 2);
                        scoreLine.push(top + second);

                    } else {
                        scoreLine.push(0);
                    }
                }
            }
            i++;
        }
        while(!scoreLine.isEmpty()){
            sumOfScoreLine += scoreLine.pop();
        }
        return sumOfScoreLine;
    }
}