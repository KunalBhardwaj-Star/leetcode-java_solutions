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
    List<TreeNode> ans = new ArrayList<>();
    HashMap<String , Integer> map = new HashMap<>();

    private String dfs(TreeNode root){
        if(root == null)
            return "null";

        String left = dfs(root.left);
        String right = dfs(root.right);

        String curr = root.val + "," + left + "," + right;

        map.put(curr , map.getOrDefault(curr , 0) + 1);

        if(map.get(curr) == 2)
            ans.add(root);

        return curr;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return ans;
    }
}