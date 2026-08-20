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
    public int maxLevelSum(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();

        int level = 1;
        int curr_level = 1;
        int sum = Integer.MIN_VALUE;

        q.offer(root);

        while(!q.isEmpty()){
            int curr_sum = 0;

            int size = q.size();

            for(int i = 0 ; i < size ; i++){
                TreeNode curr = q.poll();

                curr_sum += curr.val;

                if(curr.left != null)
                    q.offer(curr.left);

                if(curr.right != null)
                    q.offer(curr.right);
            }

            if(curr_sum > sum){
                sum = curr_sum;
                level = curr_level;
            }

            curr_level++;
        }

        return level;
    }
}