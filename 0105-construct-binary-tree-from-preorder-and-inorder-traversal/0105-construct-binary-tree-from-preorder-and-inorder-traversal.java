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
    private int preIdx;
    private HashMap<Integer , Integer> map;

    private TreeNode build(int[] preorder , int lft , int rght){
        if(lft > rght)
            return null;

        int val = preorder[preIdx++];

        TreeNode root = new TreeNode(val);

        int idx = map.get(val);

        root.left = build(preorder , lft , idx - 1);
        root.right = build(preorder , idx + 1 , rght);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIdx = 0;
        
        map = new HashMap<>();

        for(int i = 0 ; i < inorder.length ; i++){
            map.put(inorder[i] , i);
        }

        return build(preorder , 0 , inorder.length - 1);
    }
}