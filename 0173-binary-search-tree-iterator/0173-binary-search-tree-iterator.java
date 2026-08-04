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
class BSTIterator {
    TreeNode root;
    ArrayList<Integer> tree;
    int curr;
    public BSTIterator(TreeNode root) {
        this.root = root;
        this.tree = new ArrayList<>();
        this.curr = -1;

        inorder(root);
    }
    
    public int next() {
        curr++;
        return curr < tree.size() ? tree.get(curr) : -1;
    }
    
    public boolean hasNext() {
        return (curr + 1) < tree.size();
    }

    private void inorder(TreeNode head){
        if(head == null)
            return;

        inorder(head.left);
        tree.add(head.val);
        inorder(head.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */