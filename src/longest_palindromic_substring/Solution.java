package longest_palindromic_substring;

public class Solution {
    public String longestPalindrome(String s) {

        for (int l = s.length(); l > 0; l--) {
            for (int i = s.length() - l; i > -1; i--) {
                if (isPalindorme(s, i, i + l - 1))
                    return s.substring(i, i + l);
            }
        }
        return null;
    }

    boolean isPalindorme(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--)
            if (s.charAt(i) != s.charAt(j))
                return false;
        return true;
    }
}
