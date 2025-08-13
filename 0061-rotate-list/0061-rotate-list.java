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
    public int size(ListNode head){
        ListNode newSize = head;
        int size = 0;
        while(newSize != null){
            size ++;
            newSize = newSize.next;
        }
        return size;
    }
    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp = head;

        if(size(head) == 0 || k % size(head) == 0 ){
            return head;
        }

        for(int i = 1 ; i < size(head)-(k % size(head)) ; i++){
            temp = temp.next;
        }
        ListNode rotateList = temp.next;
        temp.next = null;
        ListNode dummy = rotateList;
        while(dummy.next != null){
            dummy = dummy.next;
        }
        dummy.next = head;
        head = rotateList;

        return head;
    }
}