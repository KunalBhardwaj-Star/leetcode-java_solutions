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

    ArrayList<Integer> traverse;

    int mx , mn;

    private void inorder(TreeNode root){
        if(root == null)
            return;

        inorder(root.left);
        traverse.add(root.val);
        inorder(root.right);
    }

    private void binarySearch(int lft , int rght , int target){
        if(lft > rght)
            return;

        int mid = (lft + rght) / 2;

        int curr = traverse.get(mid);

        if(curr == target){
            mx = mn = traverse.get(mid);
            return;
        }

        else if(curr > target){
            mx = mx > curr ? curr : mx;
            binarySearch(lft , mid - 1 , target);
        }

        else {
            mn = mn < curr ? curr : mn;
            binarySearch(mid + 1 , rght , target);
        }

        return ;
    }

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        traverse = new ArrayList<>();
        inorder(root);

        List<List<Integer>> ans = new ArrayList<>();

        for(int q : queries){
            mx = Integer.MAX_VALUE;
            mn = Integer.MIN_VALUE;

            binarySearch(0 , traverse.size() - 1 , q);

            mx = mx == Integer.MAX_VALUE ? -1 : mx;
            mn = mn == Integer.MIN_VALUE ? -1 : mn;

            ans.add(Arrays.asList(mn , mx));
        }

        return ans;
    }
}