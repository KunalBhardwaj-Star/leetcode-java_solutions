import java.util.*;

class Solution {  
    class slideWindow implements Comparable<slideWindow>{
        int val , idx;
        public slideWindow(int val , int idx){
            this.val = val;
            this.idx = idx;
        }
        @Override
        public int compareTo(slideWindow s2){
            return s2.val - this.val;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<slideWindow> pq = new PriorityQueue<>();
        int max[] = new int[nums.length - k + 1];
        
        for(int i = 0 ; i < k ; i++){
            pq.add(new slideWindow(nums[i] , i));
        }

        max[0] = pq.peek().val;
        
        for(int i = k ; i < nums.length ; i++){
            while(pq.size() > 0 && pq.peek().idx <= (i-k)){
                pq.remove();
            }
            pq.add(new slideWindow(nums[i] , i));
            max[i-k+1] = pq.peek().val;
        }
        return max;
    }
}