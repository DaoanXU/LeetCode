package pow;

public class Solution {
    public double pow(double x, int n) {
        boolean negative = false;
        if (n < 0) {
            negative = true;
            n = -n;
        }

        double base = x;
        double result = 1.0;
        for (; n > 0; n = n >>> 1) {
            if ((n & 1) == 1) {
                result = result * base;
            }
            base = base * base;
        }
        if (negative)
            return 1.0 / result;
        return result;
    }
}
