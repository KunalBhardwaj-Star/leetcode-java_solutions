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
    public TreeNode invertTree(TreeNode root) {

        if(root == null)
            return null;
        
        Stack<TreeNode> s = new Stack<>();

        s.push(root);

        while(!s.isEmpty()){
            TreeNode curr = s.pop();

            TreeNode temp = curr.right;
            curr.right = curr.left;
            curr.left = temp;

            if(curr.left != null)
                s.push(curr.left);

            if(curr.right != null)
                s.push(curr.right);
        }

        return root;
    }
}