package valid_parentheses;

public class Solution {
    public boolean isValid(String s) {

        char[] stack = new char[s.length()];
        int size = 0;

        for (char c : s.toCharArray()) {
            if (size == 0) {
                if (isStart(c)) {
                    stack[size] = c;
                    size++;
                } else {
                    return false;
                }
            } else {
                if (isStart(c)) {
                    stack[size] = c;
                    size++;
                } else {
                    size--;
                    if (!isMatch(stack[size], c))
                        return false;
                }
            }
        }

        return size == 0;
    }

    private boolean isStart(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private boolean isMatch(char c1, char c2) {
        switch (c1) {
        case '(':
            return c2 == ')';
        case '[':
            return c2 == ']';
        case '{':
            return c2 == '}';
        default:
            return false;
        }
    }
}
