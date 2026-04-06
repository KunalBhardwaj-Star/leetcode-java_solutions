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
    int maxLen = 0;
    public int longestZigZag(TreeNode root) {
        if(root == null) return 0;

        dfs(root.left , true , 1);
        dfs(root.right , false , 1);

        return maxLen;
    }

    private void dfs(TreeNode temp , boolean isLeft , int step){
        if(temp == null) return ;

        maxLen = Math.max(maxLen , step);

        if(isLeft){
            //zigzag pattern by calling right
            dfs(temp.right , false , step + 1);

            //Straight pattern
            dfs(temp.left , true , 1);
        } else {
            //zigzag pattern by calling left
            dfs(temp.left , true , step + 1);

            //Straight pattern
            dfs(temp.right , false , 1);
        }
    }
}
