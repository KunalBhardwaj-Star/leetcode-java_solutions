class Solution {
    private boolean binarySearch(int[][] mat , int idx , int strt , int end , int target){
        if(strt > end)
            return false;

        int mid = strt + (end - strt) / 2;

        if(mat[idx][mid] == target)
            return true;

        else if(mat[idx][mid] > target)
            return binarySearch(mat , idx , strt , mid - 1 , target);

        return binarySearch(mat , idx , mid + 1 , end , target);
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length ;
        int m = matrix[0].length;

        int lft = 0 , rght = n - 1;

        while(lft <= rght){

            int mid = (lft + rght) / 2;

            if(matrix[mid][0] <= target && matrix[mid][m-1] >= target)
                return binarySearch(matrix , mid , 0 , m - 1 , target);

            else if(matrix[mid][0] > target){
                rght = mid - 1;
            }

            else if(matrix[mid][m - 1] < target)
                lft = mid + 1;
        }

        return false;
    }
}