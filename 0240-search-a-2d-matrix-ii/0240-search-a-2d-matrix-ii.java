class Solution {
    private boolean binarySearch(int[][] mat, int target, int idx, int lft, int rght) {

        if (lft > rght)
            return false;

        int mid = lft + (rght - lft) / 2;

        if (mat[idx][mid] == target)
            return true;

        if (mat[idx][mid] > target)
            return binarySearch(mat, target, idx, lft, mid - 1);

        return binarySearch(mat, target, idx, mid + 1, rght);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            boolean found = binarySearch(matrix, target, i, 0, m - 1);
            if (found)
                return true;
        }

        return false;
    }
}