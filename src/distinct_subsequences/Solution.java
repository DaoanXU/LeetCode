package distinct_subsequences;

public class Solution {

    int numDistinct(String S, String T) {

        int m = S.length();
        int n = T.length();

        if (m == 0 || n == 0)
            return 0;

        int[] diff = new int[n + 1];
        diff[n] = 1;

        for (int i = m - 1; i > -1; i--) {
            for (int j = 0; j < n; j++) {
                if (S.charAt(i) == T.charAt(j))
                    diff[j] = diff[j] + diff[j + 1];
            }
        }

        return diff[0];
    }

}