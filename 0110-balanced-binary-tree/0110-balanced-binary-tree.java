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
    public int height(TreeNode root){
        if(root == null)return 0;

        int left = height(root.left) , right = height(root.right);
        int diff = Math.abs(left - right);

        if(left == -1 || right == -1)return -1;
        else if(diff > 1) return -1;
        else return 1 + Math.max(left , right);
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int leftH = height(root.left);
        int rightH = height(root.right);

        if(leftH == -1 || rightH == -1) return false;
        else if(Math.abs(leftH - rightH) > 1)return false;
        else return true;
    }
}