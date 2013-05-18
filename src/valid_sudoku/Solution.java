package valid_sudoku;

public class Solution {

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] == '.')
                    continue;
                if (isValidBox(board, i, j))
                    continue;
                return false;
            }
        }
        return true;
    }

    private boolean isValidBox(char[][] board, int row, int column) {
        for (int i = 0; i < 9; i++) {
            if (board[i][column] == board[row][column] && i!=row)
                return false;
            if (board[row][i] == board[row][column] && i!=column)
                return false;
        }

        int r = (row / 3) * 3;
        int c = (column / 3) * 3;
        for(int i = r; i < r + 3; i++){
            for(int j = c; j < c + 3;j++){
                if(board[i][j] == board[row][column] && i!=row && j!=column)
                    return false;
            }
        }
        return true;
    }
}

