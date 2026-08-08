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
    private int idx = 0;
    private TreeNode buildTreeUsingPreorder(int[] preorder , int min , int max){
        if(idx == preorder.length)
            return null;

        int val = preorder[idx];

        if(val < min || val > max)
            return null;

        idx++;

        TreeNode root = new TreeNode(val);
        root.left = buildTreeUsingPreorder(preorder , min , val);
        root.right = buildTreeUsingPreorder(preorder , val , max);
        
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildTreeUsingPreorder(preorder , Integer.MIN_VALUE , Integer.MAX_VALUE);
    }
}