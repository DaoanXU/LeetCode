package wildcard_matching;

public class SolutionRecursive {
    private String preProcessing(String p) {
        StringBuilder sb = new StringBuilder();
        boolean haveStar = false;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '?')
                sb.append('?');
            else if (p.charAt(i) == '*')
                haveStar = true;
            else {
                if (haveStar)
                    sb.append('*');
                sb.append(p.charAt(i));
                haveStar = false;
            }
        }
        if (haveStar)
            sb.append('*');
        return sb.toString();
    }

    public boolean isMatch(String s, String p) {
        p = preProcessing(p);
        return isMatchHelp(s, p);
    }

    public boolean isMatchHelp(String s, String p) {
        if (p.length() == 0) {
            if (s.length() == 0)
                return true;
            return false;
        }

        if (s.length() == 0) {
            if (p.equals("*"))
                return true;
            return false;
        }

        if (p.charAt(0) == '?')
            return isMatchHelp(s.substring(1), p.substring(1));

        if (p.charAt(0) == '*')
            return isMatchHelp(s, p.substring(1)) || isMatchHelp(s.substring(1), p);

        if (s.charAt(0) == p.charAt(0))
            return isMatchHelp(s.substring(1), p.substring(1));

        return false;
    }
}
