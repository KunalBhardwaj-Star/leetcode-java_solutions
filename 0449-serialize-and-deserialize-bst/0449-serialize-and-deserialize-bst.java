/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    int idx;

    private void dfsSerial(StringBuilder sb , TreeNode root){
        if(root == null)
            return;
        
        sb.append(root.val).append(",");
        dfsSerial(sb , root.left);
        dfsSerial(sb , root.right);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "";

        StringBuilder sb = new StringBuilder();

        dfsSerial(sb , root);

        return sb.toString();
    }

    private TreeNode dfsDeserial(String[] s , int max , int min){
        if(idx >= s.length)
            return null;

        int val = Integer.parseInt(s[idx]);

        if(val < min || val > max)
            return null;

        idx++;

        TreeNode root = new TreeNode(val);

        root.left = dfsDeserial(s , val , min);
        root.right = dfsDeserial(s , max , val);

        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(""))
            return null;
        
        String[] s = data.split(",");
        idx = 0;

        return dfsDeserial(s , Integer.MAX_VALUE , Integer.MIN_VALUE);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;