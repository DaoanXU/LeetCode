package reverse_integer;

public class SolutionNoCheck {

    public int reverse(int x) {
        boolean negative = x < 0;
        if (negative)
            x = -x;

        int result = 0;
        while (x > 0) {
            int digit = x % 10;
            x = x / 10;
            result = result * 10 + digit;
        }
        return negative ? -result : result;
    }

}
