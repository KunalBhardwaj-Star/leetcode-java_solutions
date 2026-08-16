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

    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);

        return ans;
    }

    private int dfs(TreeNode root){
        if(root == null)
            return 0;

        int leftGain = Math.max(0 , dfs(root.left));
        int rightGain = Math.max(0 , dfs(root.right));

        int pathThrough = root.val + leftGain + rightGain;

        ans = Math.max(ans , pathThrough);

        return root.val + Math.max(leftGain , rightGain);
    }


}