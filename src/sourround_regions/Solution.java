package sourround_regions;

import java.util.Stack;

public class Solution {

    boolean visited[][];
    int m;
    int n;

    public void solve(char[][] board) {
        m = board.length;
        if (m == 0)
            return;
        n = board[0].length;
        visited = new boolean[m + 2][n + 2];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (board[i][j] == 'X')
                    visited[i + 1][j + 1] = true;

        dfs();

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (!visited[i + 1][j + 1])
                    board[i][j] = 'X';
    }

    class intStack {
        private int[] arr;
        private int size;

        intStack() {
            arr = new int[(m + 2) * (n + 2)];
            size = 0;
        }

        int pop() {
            size = size - 1;
            return arr[size];
        }

        boolean isEmpty() {
            return (size == 0);
        }

        void push(int x) {
            arr[size] = x;
            size = size + 1;
        }
    }

    void dfs() {

        intStack X = new intStack();
        intStack Y = new intStack();
        X.push(0);
        Y.push(0);

        while (!X.isEmpty()) {
            int x = X.pop();
            int y = Y.pop();

            if (visited[x][y])
                continue;

            visited[x][y] = true;

            int nx;
            int ny;

            nx = x;
            ny = y + 1;
            if (ny < n + 2 && !visited[nx][ny]) {
                X.push(nx);
                Y.push(ny);
            }

            nx = x;
            ny = y - 1;
            if (ny > -1 && !visited[nx][ny]) {
                X.push(nx);
                Y.push(ny);
            }

            nx = x + 1;
            ny = y;
            if (nx < m + 2 && !visited[nx][ny]) {
                X.push(nx);
                Y.push(ny);
            }

            nx = x - 1;
            ny = y;
            if (nx > -1 && !visited[nx][ny]) {
                X.push(nx);
                Y.push(ny);
            }
        }
    }
}
