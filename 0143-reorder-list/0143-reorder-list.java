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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        
        ListNode slow = head , fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode curr = slow.next , prev = null;
        slow.next = null;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode temp = head;

        while(prev != null && temp != null){
            ListNode dummy_prev = prev.next;
            ListNode dummy_temp = temp.next;
            prev.next = temp.next;
            temp.next = prev;
            prev = dummy_prev;
            temp = dummy_temp;
        }
    }
}