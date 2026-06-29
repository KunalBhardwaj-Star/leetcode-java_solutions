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

        for(int i = 0 ; i < n ; i++){
            boolean found = binarySearch(matrix , i , 0 , m - 1 , target);

            if(found)
                return true;
        }

        return false;
    }
}