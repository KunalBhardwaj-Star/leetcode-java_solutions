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
    private void checkPosition(TreeNode temp , int val){
        if(temp.val > val && temp.left == null){
            temp.left = new TreeNode(val);
            return;
        }

        else if(temp.val < val && temp.right == null){
            temp.right = new TreeNode(val);
            return;
        }

        else if(temp.val > val)
            checkPosition(temp.left , val);

        else checkPosition(temp.right , val);

    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
            return new TreeNode(val);
        checkPosition(root , val);
        return root;
    }
}