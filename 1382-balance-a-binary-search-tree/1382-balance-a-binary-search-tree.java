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
    public ArrayList<Integer> num = new ArrayList<>();

    public void inorder(TreeNode root){
        if(root == null)return ;
        inorder(root.left);
        num.add(root.val);
        inorder(root.right);
    }

    public TreeNode BST(int start , int end){
        if (start > end) return null;

        int mid = (start + end)/2;

        TreeNode newTree = new TreeNode(num.get(mid));

        newTree.left = BST(start , mid - 1);
        newTree.right = BST(mid + 1 , end);

        return newTree;
    }

    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return BST(0 , num.size()-1);
    }
}