/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 import java.util.*;
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer>s = new Stack<>();
        ArrayList<Integer>AL = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            AL.add(temp.val);
            temp = temp.next;
        }
        int[] nextGreat = new int[AL.size()];
        for(int n = AL.size()-1; n >=0 ; n--){
            while(!s.isEmpty() && s.peek() <= AL.get(n)){
                s.pop();
            }
            if(s.isEmpty()){
                nextGreat[n] = 0;
            }
            else {
                nextGreat[n] = s.peek();
            }
            s.push(AL.get(n));
        } 
        return nextGreat;
    }
}