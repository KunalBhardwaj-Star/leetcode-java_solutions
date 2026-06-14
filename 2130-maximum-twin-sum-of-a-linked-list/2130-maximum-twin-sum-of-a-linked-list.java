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
    private int size(ListNode root , ArrayList<Integer>nodeElement){
        ListNode temp = root;

        int size = 0;

        while(temp != null){
            nodeElement.add(temp.val);
            temp = temp.next;
            size++;
        }

        return size;
    }
    public int pairSum(ListNode head) {
        ArrayList<Integer>nodeElement = new ArrayList<>();
        int sizeOfLL = size(head , nodeElement);

        int max = Integer.MIN_VALUE;

        for(int i = 0 ; i < sizeOfLL / 2 ; i++){
            int currSum = nodeElement.get(i) + nodeElement.get(sizeOfLL - i - 1);
            max = Math.max(max , currSum);
        }

        return max;
    }
}