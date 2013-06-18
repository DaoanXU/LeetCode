package palindrome_partitioning_ii;

import java.util.Arrays;

public class Solution {

    public int minCut(String s) {

        boolean[][] isPal = new boolean[s.length()][s.length()];

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

        int[] minPart = new int[s.length() + 1];
        Arrays.fill(minPart, Integer.MAX_VALUE);
        minPart[s.length()] = 0;

        for (int i = s.length() - 1; i > -1; i--) {
            for (int j = i; j < s.length(); j++) {
                if (isPal[i][j] && minPart[j + 1] + 1 < minPart[i])
                    minPart[i] = minPart[j + 1] + 1;
            }
        }

        return minPart[0] - 1;
    }
}