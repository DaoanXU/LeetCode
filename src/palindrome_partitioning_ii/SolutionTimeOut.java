package palindrome_partitioning_ii;

import java.util.ArrayList;

public class SolutionTimeOut {

    boolean[][] isPal;
    String s;
    int minCut;
    int currentCut;

    public int minCut(String s) {

        isPal = new boolean[s.length()][s.length()];
        this.s = s;
        minCut = Integer.MAX_VALUE;
        currentCut = 0;

        isPal[0][0] = true;
        for (int i = 1; i < s.length(); i++) {
            isPal[i][i] = true;
            isPal[i - 1][i] = s.charAt(i - 1) == s.charAt(i);
        }

        for (int l = 2; l < s.length(); l++) {
            for (int i = 0; i + l < s.length(); i++) {
                isPal[i][i + l] = (s.charAt(i) == s.charAt(i + l))
                        && isPal[i + 1][i + l - 1];
            }
        }
        partitionHelper(s.length());

        return minCut - 1;
    }

    public void partitionHelper(int end) {
        if (currentCut > minCut)
            return;

        if (end == 0) {
            minCut = currentCut;
            return;
        }

        for (int i = 0; i < end; i++) {
            if (isPal[i][end - 1]) {
                currentCut++;
                partitionHelper(i);
                currentCut--;
            }
        }
    }
}