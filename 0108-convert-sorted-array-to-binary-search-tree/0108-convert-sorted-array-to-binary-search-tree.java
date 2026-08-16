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
    private TreeNode createBST(int[] nums , int lft , int rght){
        if(lft > rght)
            return null;

        int mid = (lft + rght) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = createBST(nums , lft , mid - 1);
        root.right = createBST(nums , mid + 1 , rght);

        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums , 0 , nums.length - 1);
    }
}