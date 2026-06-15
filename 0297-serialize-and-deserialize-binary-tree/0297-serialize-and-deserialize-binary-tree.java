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
    int idx = 0;
    
    private void dfsSerial(StringBuilder curr , TreeNode root){
        if(root == null){
            curr.append("null").append(",");
            return;
        }

        curr.append(root.val).append(",");
        dfsSerial(curr , root.left);
        dfsSerial(curr , root.right);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfsSerial(sb , root);

        return sb.toString();
    }

    private TreeNode dfsDeserial(String[] preorder){
        if(idx >= preorder.length)
            return null;

        if(preorder[idx].equals("null")){
            idx++;
            return null;
        }

        int curr = Integer.parseInt(preorder[idx++]);

        TreeNode root = new TreeNode(curr);
        root.left = dfsDeserial(preorder);
        root.right = dfsDeserial(preorder);

        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] s = data.split(",");
        idx = 0;
        if(s[0].equals("null"))
            return null;

        return dfsDeserial(s);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));