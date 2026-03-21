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
    private int size(ListNode root){
        ListNode temp = root;

        int size = 0;

        while(temp != null){
            size++;
            temp = temp.next;
        }

        return size;
    }
    public int pairSum(ListNode head) {
        int s = size(head);
        int[] arr = new int[s];
        int i = 0;

        ListNode temp = head;

        while(temp != null){
            arr[i++] = temp.val;
            temp = temp.next;
        }

        int max = 0;

        for(int j = 0 ; j < s/2 ; j++){
            max = Math.max(max , arr[j] + arr[s - j - 1]);
        }

        return max;
    }
}