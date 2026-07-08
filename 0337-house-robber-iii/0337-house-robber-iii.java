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
    public int rob(TreeNode root) {
        int[] helper = maxRob(root);
        return Math.max(helper[0] , helper[1]);
    }

    private int[] maxRob(TreeNode root){
        if(root == null){
            return new int[]{0 , 0};
        }

        int[] lft = maxRob(root.left);
        int[] rght = maxRob(root.right);

        int withRob = root.val + lft[1] + rght[1];
        int withoutRob = Math.max(lft[0] , lft[1]) + Math.max(rght[0] , rght[1]);

        return new int[] {withRob , withoutRob};
    }
}