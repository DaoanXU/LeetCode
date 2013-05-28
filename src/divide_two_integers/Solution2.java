package divide_two_integers;

public class Solution2 {

    public int divide(int dividend, int divisor) {

        if (divisor == 0)
            throw new ArithmeticException("devide by zero");

        // convert dividend and divisor to negative numbers a and b
        int a = (dividend < 0) ? dividend : (0 - dividend);
        int b = (divisor < 0) ? divisor : (0 - divisor);

        // check the sign of the output
        return (dividend ^ divisor) < 0 ? (0 - divideHelper(a, b))
                : divideHelper(a, b);
    }

    /**
     * 
     * @param a
     *            should be negative number or 0
     * @param b
     *            should be negative number
     * @return value of a/b
     */
    int divideHelper(int a, int b) {

        int base = 1;
        while (a <= b << 1 && b << 1 < 0) {
            b <<= 1;
            base <<= 1;
        }

        int result = 0;
        while (base != 0) {
            if (a <= b) {
                a = a - b;
                result += base;
            }
            base >>>= 1;
            b >>= 1;
        }
        return result;

    }
}
