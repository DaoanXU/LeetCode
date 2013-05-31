package spiral_matrix_ii;

public class Solution {

    int[] index = new int[2];
    int whichIndex;
    int step;
    boolean closed;

    int count;
    int[] max = new int[2];

    void init(int m, int n) {
        if (m == 1 && n == 1) {
            closed = true;
            index[0] = 0;
            index[1] = 0;
            return;
        }

        index[0] = 0;
        index[1] = 0;

        max[0] = m;
        max[1] = n;
        count = 1;

        whichIndex = 1;
        step = 1;
        closed = false;

        if (n == 1) {
            whichIndex = 0;
            step = 1;
        }
    }

    void turn() {
        if (whichIndex == 0) {
            whichIndex = 1;
            step = step * -1;
        }
        else {
            whichIndex = 0;
        }
        max[whichIndex]--;
        if (max[whichIndex] <= 0)
            closed = true;
    }

    void next() {
        index[whichIndex] += step;
        count++;
        if (count == max[whichIndex]) {
            count = 0;
            turn();
        }
    }

    public int[][] generateMatrix(int n) {

        init(n, n);
        int sqr = n * n + 1;
        int[][] result = new int[n][n];
        for (int i = 1; i < sqr; i++) {
            result[index[0]][index[1]] = i;
            next();
        }
        return result;
    }
}