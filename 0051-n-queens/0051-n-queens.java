import java.util.*;

class Solution {

    List<List<String>> ans = new ArrayList<>();

    private boolean isSafe(List<List<String>> board, int row, int col) {

        for (int i = row - 1; i >= 0; i--) {
            if (board.get(i).get(col).equals("Q"))
                return false;
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).get(j).equals("Q"))
                return false;
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < board.size(); i--, j++) {
            if (board.get(i).get(j).equals("Q"))
                return false;
        }

        return true;
    }

    private void backtrack(List<List<String>> board, int row) {

        if (row == board.size()) {

            List<String> temp = new ArrayList<>();

            for (List<String> r : board) {
                StringBuilder sb = new StringBuilder();

                for (String cell : r)
                    sb.append(cell);

                temp.add(sb.toString());
            }

            ans.add(temp);
            return;
        }

        for (int col = 0; col < board.size(); col++) {

            if (isSafe(board, row, col)) {

                board.get(row).set(col, "Q");

                backtrack(board, row + 1);

                board.get(row).set(col, ".");
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> board = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            board.add(new ArrayList<>(Collections.nCopies(n, ".")));
        }

        backtrack(board, 0);

        return ans;
    }
}