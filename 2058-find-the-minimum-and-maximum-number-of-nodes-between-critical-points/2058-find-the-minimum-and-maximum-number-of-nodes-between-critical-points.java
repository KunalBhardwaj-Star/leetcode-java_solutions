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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ArrayList<Integer> node = new ArrayList<>();

        ListNode temp = head.next;
        ListNode prev = head;
        int idx = 1;

        while(temp.next != null){
            int pre = prev.val;
            int curr = temp.val;
            int next = temp.next.val;

            if((pre < curr && curr > next) || (pre > curr && curr < next))
                node.add(idx);

            idx++;
            prev = temp;
            temp = temp.next;
        }

        int n = node.size();

        if(n < 2)
            return  new int[]{-1 , -1};


        int max = node.get(n - 1) - node.get(0);
        
        int min = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            min = Math.min(min, node.get(i) - node.get(i - 1));
        }


        return new int[]{min , max};
    }
}