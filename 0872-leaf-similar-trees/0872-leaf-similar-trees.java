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
    private void leafNode(TreeNode root , List<Integer> r){
        if(root == null)
            return;
        
        if(root.left == null && root.right == null){
            r.add(root.val);
            return;
        }

        leafNode(root.left , r);
        leafNode(root.right , r);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> r1 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();

        leafNode(root1 , r1);
        leafNode(root2 , r2);

        return r1.equals(r2);
    }
}