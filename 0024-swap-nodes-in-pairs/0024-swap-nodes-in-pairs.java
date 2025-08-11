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
    public ListNode swapPairs(ListNode head) {

        if(head == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null ){
            int temp = slow.val;
            slow.val = fast.val;
            fast.val = temp;

            slow = fast.next;
            if(slow == null){
                break;
            }
            else {
                fast = slow.next;
            }
        }

        return head;
    }
}