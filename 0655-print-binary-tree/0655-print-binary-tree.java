class Solution {
    private int height(TreeNode root) {
        if (root == null)
            return 0;

        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left, right) + 1;
    }

    private void fill(TreeNode root, List<List<String>> ans,
                      int row, int left, int right) {

        if (root == null)
            return;

        int mid = (left + right) / 2;

        ans.get(row).set(mid, String.valueOf(root.val));

        fill(root.left, ans, row + 1, left, mid - 1);
        fill(root.right, ans, row + 1, mid + 1, right);
    }

    public List<List<String>> printTree(TreeNode root) {

        int m = height(root);

        int n = (int) Math.pow(2, m) - 1;

        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            List<String> curr = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                curr.add("");
            }

            ans.add(curr);
        }

        fill(root, ans, 0, 0, n - 1);

        return ans;
    }
}