package n_queen_ii;

public class Solution {
    int n;
    int fill;
    int sum;

    public int totalNQueens(int n) {
        this.n = n;
        this.fill = (1 << n) - 1;
        this.sum = 0;
        test(0,0,0);
        return sum;
    }

    public void test(int down, int left, int right) {
        if(down == fill){
            sum ++;
            return;
        }

        int canNot = down | left | right;
        if(canNot == fill)
            return;
        for (int i = 0; i < n; i++) {
            int put = 1 << i;
            if ((canNot & put) == 0) {
                test((down | put), (left | put) << 1, (right | put) >>> 1);
            }
        }
    }
}