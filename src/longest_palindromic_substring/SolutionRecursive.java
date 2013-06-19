package longest_palindromic_substring;

public class SolutionRecursive {
    public String longestPalindrome(String s) {
        return finder(s, 0, 0);
    }

    String finder(String s, int start, int currentMax) {
        if (s.length() - start <= currentMax)
            return null;

        int stop = start + currentMax - 1;
        for (int i = s.length() - 1; i > stop; i--) {
            if (isPalindorme(s, start, i)) {
                String next = finder(s, start + 1, i - start + 1);
                if (next == null)
                    return s.substring(start, i + 1);
                return next;
            }
        }
        String next = finder(s, start + 1, currentMax);
        if (next == null)
            return null;
        return next;
    }

    boolean isPalindorme(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--)
            if (s.charAt(i) != s.charAt(j))
                return false;
        return true;
    }
}
