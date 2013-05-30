package n_queen;

import java.util.ArrayList;

public class Solution {
    int n;
    int fill;
    int sum;
    ArrayList<String[]> result;
    String[] oneSolution;
    int row;

    public ArrayList<String[]> solveNQueens(int n) {
        this.n = n;
        this.fill = (1 << n) - 1;
        this.sum = 0;
        this.result = new ArrayList<String[]>();
        this.oneSolution = new String[n];
        this.row = 0;
        test(0, 0, 0);
        return result;
    }

    public void test(int down, int left, int right) {
        if (down == fill) {
            sum++;
            addToResult();
            return;
        }

        int canNot = down | left | right;
        if (canNot == fill)
            return;
        for (int i = 0; i < n; i++) {
            int put = 1 << i;
            if ((canNot & put) == 0) {
                insert(put);
                test((down | put), (left | put) << 1, (right | put) >>> 1);
                removeLast();
            }
        }
    }

    private void addToResult() {
        String[] oneSolution = new String[n];
        for (int i = 0; i < n; i++) {
            oneSolution[i] = this.oneSolution[i];
        }
        result.add(oneSolution);
    }

    private void insert(int put) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if ((put & 1) == 1)
                sb.append('Q');
            else
                sb.append('.');
            put >>>= 1;
        }
        oneSolution[row] = sb.toString();
        row++;
    }

    private void removeLast() {
        row--;
    }
}