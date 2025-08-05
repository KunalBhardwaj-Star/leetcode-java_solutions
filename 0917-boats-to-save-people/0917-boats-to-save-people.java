import java.util.*;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int lighter = 0 , heavier = people.length - 1;
        int count = 0;
        Arrays.sort(people);
        while(lighter <= heavier){
            if(people[lighter] + people[heavier] <= limit){
                count ++;
                lighter ++;
                heavier --;
            } else {
                count ++;
                heavier --;
            }
        }
        return count;
    }
}