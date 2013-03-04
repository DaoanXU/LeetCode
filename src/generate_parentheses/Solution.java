package generate_parentheses;

import java.util.ArrayList;

public class Solution {
    private void foo(String str, int starts, int ends, ArrayList<String> result) {
        if (starts > ends)
            return;
        if (starts < 0)
            return;
        if (starts == 0 && ends == 0) {
            result.add(str);
            return;
        }
        foo(str + '(', starts - 1, ends, result);
        foo(str + ')', starts, ends - 1, result);
    }

    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        foo("", n, n, result);
        return result;
    }
}
