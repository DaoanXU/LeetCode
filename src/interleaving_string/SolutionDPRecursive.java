package interleaving_string;

public class SolutionDPRecursive {

    int[][] result;
    String s1;
    String s2;
    String s3;

    public boolean isInterleave(String s1, String s2, String s3) {

        if (s1.length() + s2.length() != s3.length())
            return false;

        result = new int[s1.length() + 1][s2.length() + 1];
        result[0][0] = 1;

        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;

        return getResult(s1.length(), s2.length());
    }

    boolean getResult(int i, int j) {
        if (i < 0 || j < 0)
            return false;

        if (result[i][j] == 1)
            return true;

        if (result[i][j] == -1)
            return false;

        int index1 = i - 1;
        int index2 = j - 1;
        int index3 = i + j - 1;

        boolean ans = false;
        if (index1 >= 0)
            ans = ans || (s1.charAt(index1) == s3.charAt(index3) && getResult(i - 1, j));
        if (index2 >= 0)
            ans = ans || (s2.charAt(index2) == s3.charAt(index3) && getResult(i, j - 1));

        if (ans) {
            result[i][j] = 1;
            return true;
        }
        result[i][j] = -1;
        return false;
    }
}