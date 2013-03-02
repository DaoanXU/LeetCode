package reverse_integer;

public class Solution2 {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE)
            throw new NumberFormatException("Can not revese" + x);
        boolean negative = x < 0;
        if (negative)
            x = -x;
        StringBuffer it = new StringBuffer();
        it.append(x);
        it.reverse();
        return negative ? -Integer.parseInt(it.toString()) : Integer
                .parseInt(it.toString());
    }
}