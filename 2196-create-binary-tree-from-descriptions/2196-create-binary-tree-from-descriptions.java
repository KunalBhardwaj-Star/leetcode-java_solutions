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
    // private class Children{
    //     int data;
    //     boolean isLeft ;
    //     Children(int data , boolean isLeft){
    //         this.data = data;
    //         this.isLeft = isLeft;
    //     }
    // }
    private class StoreHash {
        int[] child;
        boolean isChild;

        StoreHash(boolean isChild) {
            this.child = new int[] { -1, -1 };
            this.isChild = isChild;
        }
    }

    private TreeNode createTree(int nodeVal , HashMap<Integer , StoreHash> map){
        if(nodeVal == -1)
            return null;

        TreeNode root = new TreeNode(nodeVal);
        StoreHash curr = map.get(nodeVal);
        root.left = createTree(curr.child[0] , map);
        root.right = createTree(curr.child[1] , map);

        return root;
    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer , StoreHash> map = new HashMap<>();

        //1. Creating HashMap of given description

        for(int[] curr : descriptions){
            int node = curr[0] , child = curr[1];
            boolean isLeft = curr[2] == 1 ? true : false;
            
            if(!map.containsKey(node))
                map.put(node , new StoreHash(false));

            if(!map.containsKey(child))
                map.put(child , new StoreHash(true));
            
            map.get(child).isChild = true;

            if(isLeft)
                map.get(node).child[0] = child;
            else 
                map.get(node).child[1] = child;
        }

        //2. Find root node value using iteration 
        int root_node = -1;

        for(int key : map.keySet())
            if(!map.get(key).isChild)
                root_node = key;

        //3. Create Tree
        TreeNode root = createTree(root_node , map);
        return root;
    }
}