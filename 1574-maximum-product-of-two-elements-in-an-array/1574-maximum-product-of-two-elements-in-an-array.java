import java.util.*;

class Solution {
    class Element implements Comparable<Element> {
        int data;
        public Element(int data){
            this.data = data;
        }
        @Override
        public int compareTo(Element E1){
            return E1.data - this.data;
        }
    }
    public int maxProduct(int[] nums) {
        PriorityQueue<Element> pq = new PriorityQueue<>();
        for(int i = 0; i < nums.length ; i++){
            pq.add(new Element(nums[i]));
        }
        return (pq.remove().data-1) * (pq.peek().data - 1);
    }
}