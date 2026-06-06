class Solution {
    private boolean dfs(char[][] board, int row, int cols, int idx, String word) {
        if (idx == word.length())
            return true;

        if (row < 0 || row >= board.length ||
                cols < 0 || cols >= board[0].length ||
                board[row][cols] != word.charAt(idx))
            return false;

        char temp = board[row][cols];
        board[row][cols] = '#';

        boolean found = dfs(board, row + 1, cols, idx + 1, word) ||
                dfs(board, row - 1, cols, idx + 1, word) ||
                dfs(board, row, cols + 1, idx + 1, word) ||
                dfs(board, row, cols - 1, idx + 1, word);

        board[row][cols] = temp;

        return found;
    }

    public boolean exist(char[][] board, String word) {
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                if(dfs(board , i , j , 0 , word))
                    return true;
            }
        }

        return false;
    }
}