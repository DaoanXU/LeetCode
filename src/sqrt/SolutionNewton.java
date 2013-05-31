package sqrt;

public class SolutionNewton {
    public class Solution {
        public int sqrt(int x) {
            if (x == 0)
                return 0;
            if (x == 1)
                return 1;

            double value = x;
            int intvalue = x;
            while (intvalue > 46340 || intvalue * intvalue > x) {
                value = (value * value + x) / (2 * value);
                intvalue = (int) value;
            }
            return intvalue;
        }
    }
}
