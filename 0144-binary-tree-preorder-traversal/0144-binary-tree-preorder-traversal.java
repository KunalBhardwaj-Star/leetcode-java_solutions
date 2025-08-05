import java.util.*;
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
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        preOrderTra(root , result);
        return result;
    }

    public static void preOrderTra(TreeNode root , List<Integer> result){
        if(root == null){
            return ;
        }
        result.add(root.val);
        preOrderTra(root.left , result);
        preOrderTra(root.right , result);

    }
}