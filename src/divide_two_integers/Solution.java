package divide_two_integers;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * 
 * @author Daoan XU
 */
public class Solution {

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
        if (a > b)
            return 0;
        if (a == b)
            return 1;

        // shift b to align a and compare with a
        int diff = bitDiff(a, b);
        if (a < (b << diff))
            return (1 << diff) + divideHelper(a - (b << diff), b);
        diff--;
        return (1 << diff) + divideHelper(a - (b << diff), b);
    }

    /**
     * 
     * @param a
     *            should be negative number
     * @param b
     *            should be negative number and a<b
     * @return the difference of number of 1s as prefix in a and b. or number of
     *         bits b needs to shift to align a
     */
    int bitDiff(int a, int b) {
        int count = -1;
        while (a < b && b < 0) {
            b <<= 1;
            count++;
        }
        return count;
    }
}
