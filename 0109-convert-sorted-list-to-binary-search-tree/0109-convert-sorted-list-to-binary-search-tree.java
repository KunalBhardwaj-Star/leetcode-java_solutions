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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private ListNode current;
    public TreeNode sortedListToBST(ListNode head) {
        int size = getSize(head);
        current = head ;

        return toBST(0 , size - 1);
    }

    private int getSize(ListNode list){
        ListNode temp = list;
        int size = 0;

        while(temp != null){
            size++;
            temp = temp.next;
        }

        return size;
    }

    private TreeNode toBST(int start , int end){
        if(start > end) return null;
        int mid = (start + end) / 2;

        TreeNode left = toBST(start , mid - 1);

        TreeNode root = new TreeNode(current.val);

        current = current.next;

        TreeNode right = toBST(mid + 1 , end);

        root.left = left;
        root.right = right;

        return root;
    }
}