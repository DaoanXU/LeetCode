package valid_number;

public class Solution {
    public boolean isNumber(String s) {
        return s.matches(
                "^(\\s*)" +
                "(\\+|\\-)?" +
                "(\\d*)" + "(\\.\\d|\\d\\.|\\d)" + "(\\d*)" +
                "((e|E)(\\+|\\-)?\\d+)?" +
                "(\\s*)$");
    }
}
