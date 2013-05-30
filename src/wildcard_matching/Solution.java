package wildcard_matching;

public class Solution {
    int firstMatch(String s, int fromIndex, String p) {
        for (int i = fromIndex; i < s.length() - p.length() + 1; i++) {
            if (headMatch(s, i, p))
                return i;
        }
        return -1;
    }

    boolean headMatch(String s, int fromIndex, String p) {
        if (s.length() < fromIndex + p.length() || fromIndex < 0)
            return false;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) != '?'
                    && p.charAt(i) != s.charAt(i + fromIndex))
                return false;
        }

        return true;
    }

    boolean isMatch(String s, String[] tokens) {

        int index = 0;
        for (String token : tokens) {
            index = firstMatch(s, index, token);
            if (index == -1)
                return false;
            index = index + token.length();
        }

        return true;
    }

    public boolean isMatch(String s, String p) {

        if (p.equals("")) {
            if (s.equals(""))
                return true;
            return false;
        }

        if (!p.contains("*")) {
            return s.length() == p.length() && headMatch(s, 0, p);
        }

        String[] tokens = p.split("(\\*)+");

        if (p.charAt(0) != '*') {
            if (!headMatch(s, 0, tokens[0]))
                return false;
        }

        if (p.charAt(p.length() - 1) != '*') {
            if (!headMatch(s
                    , s.length() - tokens[tokens.length - 1].length()
                    , tokens[tokens.length - 1]))
                return false;
        }

        return isMatch(s, tokens);
    }
}