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

    private int ans = 0;

    private int calculate(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        int count = 0;
        int sum = 0;

        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            sum += curr.val;
            count++;

            if(curr.left != null)
                q.offer(curr.left);

            if(curr.right != null)
                q.offer(curr.right);
        }

        return sum / count;
    }


    private void average(TreeNode root){
        if(root == null)
            return;

        int avg = calculate(root);
        
        if(root.val == avg)
            ans++;

        average(root.left);
        average(root.right);
    }
    public int averageOfSubtree(TreeNode root) {
        if(root == null)
            return 0;

        if(root.left == null && root.right == null)
            return 1;

        average(root);

        return ans;
    }
}