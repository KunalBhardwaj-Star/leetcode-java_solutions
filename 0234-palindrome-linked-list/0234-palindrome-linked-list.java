import java.util.*;

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
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        Stack<Integer> num = new Stack<>();
        while(temp != null){
            num.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        while(temp != null) {
            if(temp.val!=num.pop()){
                return false;
            }
            temp = temp.next;
        }
        return true;
    }
}