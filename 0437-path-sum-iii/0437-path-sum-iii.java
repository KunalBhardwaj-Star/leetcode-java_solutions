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
    int count = 0;

    private void dfs(TreeNode root , long currSum , int targetSum , HashMap<Long , Integer> map){
        if(root == null)
            return;

        currSum += root.val;

        count += map.getOrDefault(currSum - targetSum , 0);

        map.put(currSum , map.getOrDefault(currSum , 0) + 1);

        dfs(root.left , currSum , targetSum , map);

        dfs(root.right , currSum , targetSum , map);

        map.put( currSum , map.get(currSum) - 1);
    }

    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long , Integer> map = new HashMap<>();

        map.put(0L , 1);

        dfs(root , 0L , targetSum , map);

        return count;
    }
}