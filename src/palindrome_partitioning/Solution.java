package palindrome_partitioning;

import java.util.ArrayList;

public class Solution {

    boolean[][] isPal;
    String s;

    public ArrayList<ArrayList<String>> partition(String s) {

        isPal = new boolean[s.length()][s.length()];
        this.s = s;

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

        return partitionHelper(s.length());
    }

    public ArrayList<ArrayList<String>> partitionHelper(int end) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if (end == 0) {
            result.add(new ArrayList<String>());
            return result;
        }
        for (int i = 0; i < end; i++) {
            if (isPal[i][end - 1]) {
                for (ArrayList<String> it : partitionHelper(i)) {
                    it.add(s.substring(i, end));
                    result.add(it);
                }
            }
        }
        return result;
    }
}
