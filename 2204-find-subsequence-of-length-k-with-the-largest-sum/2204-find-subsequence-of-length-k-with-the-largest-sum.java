import java.util.*;

class Solution {
    class largeSum implements Comparable<largeSum>{
        int idx , data;
        public largeSum(int idx , int data){
            this.data = data;
            this.idx = idx;
        }

        @Override
        public int compareTo(largeSum L1){
            return L1.data - this.data;
        }
    }
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<largeSum> pq = new PriorityQueue<>();
        int element[][] = new int[k][2];

        for(int i = 0 ; i < nums.length; i++){
            pq.add(new largeSum( i , nums[i]));
        }

        for(int i = 0 ; i < k ; i++){
            largeSum newPQ = pq.remove();
            element[i][0] = newPQ.idx;
            element[i][1] = newPQ.data;
        }

        Arrays.sort(element , Comparator.comparingInt(a -> a[0]));
         
        int result[] = new int[k];

        for(int i = 0 ; i < k ; i++){
            result[i] = element[i][1];
        }

        return result;
    }
}