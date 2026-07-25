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
    int count;
    private int dfs(TreeNode node){
        if(node == null)
            return Integer.MIN_VALUE;

        int lft = dfs(node.left);
        int rght = dfs(node.right);

        int subTreeMax = Math.max(node.val , Math.max(lft , rght));

        if(subTreeMax == node.val)
            count++;

        return subTreeMax;
    }
    public int countDominantNodes(TreeNode root) {
        dfs(root);

        return count;
    }
}