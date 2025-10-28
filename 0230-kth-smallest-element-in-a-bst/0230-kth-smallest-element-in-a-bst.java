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

    public void inorder(TreeNode root , ArrayList<Integer> sort){
        if(root == null) return ;
        inorder(root.left , sort );
        sort.add(root.val);
        inorder(root.right , sort );
    }
    
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> sort = new ArrayList<>();

        inorder(root , sort );
        return sort.get(k-1);
    }
}