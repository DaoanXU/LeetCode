package sudoku_solver;

public class SolutionRecursive {
    private boolean isValidBox(char[][] board, int row, int column) {
        if(board[row][column] == '.')
            return true;
        for (int i = 0; i < 9; i++) {
            if (board[i][column] == board[row][column] && i != row)
                return false;
            if (board[row][i] == board[row][column] && i != column)
                return false;
        }

        int r = (row / 3) * 3;
        int c = (column / 3) * 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (board[i][j] == board[row][column] && i != row && j != column)
                    return false;
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        mySolveSudoku(board,0,0);
    }
    
    
    public boolean mySolveSudoku(char[][] board,int row, int column) {
        if(!isValidBox(board,row,column))
            return false;
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.'){
                    for (int k = 1; k < 10; k++){
                        board[i][j] = (char) (k + '0');
                        boolean found = mySolveSudoku(board,i,j);
                        if(found)
                            return true;
                    }
                    board[i][j] = '.';
                    return false;
                }
            }
        }
        return true;
    }
}
