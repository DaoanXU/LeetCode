package sudoku_solver;

import java.util.LinkedList;

public class SolutionDFS {
    private boolean isValidBox(char[][] board, int row, int column) {
        if (board[row][column] == '.')
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

    private static class Box {
        int row;
        int column;

        Box(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
    
    private static final Box done = new Box(10,10);

    private Box nextEmptyBox(char[][] board, int row, int column) {
        int i = row;
        int j = column;
        for (; i < 9; i++) {
            for (; j < 9; j++) {
                if (board[i][j] == '.')
                    return new Box(i, j);
            }
            j = 0;
        }
        return done;
    }

    public void solveSudoku(char[][] board) {
        LinkedList<Box> s = new LinkedList<Box>();
        s.add(nextEmptyBox(board, 0, 0));
        while (!s.isEmpty()) {
            Box current = s.peek();
            if(current == done)
                return;
            int currentValue = board[current.row][current.column];
            if (currentValue == '9') {
                board[current.row][current.column] = '.';
                s.pop();
            } else if (currentValue == '.') {
                board[current.row][current.column] = '1';
                if (isValidBox(board, current.row, current.column))
                    s.push(nextEmptyBox(board, current.row, current.column));
            } else {
                board[current.row][current.column]++;
                if (isValidBox(board, current.row, current.column))
                    s.push(nextEmptyBox(board, current.row, current.column));
            }
        }
    }
}
