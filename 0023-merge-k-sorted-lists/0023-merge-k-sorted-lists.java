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
    private ListNode mergeSort(ListNode l1 , ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }

            temp = temp.next;
        }

        temp.next = l1 != null ? l1 : l2;

        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;

        if(len == 0 || (lists[0] == null && len == 1))
            return null;

        ListNode ans = lists[0];

        for(int i = 1 ; i < lists.length; i++){
            ans = mergeSort(ans , lists[i]);
        }

        return ans;
    }
}