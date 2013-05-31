package climbing_stairs;

public class Solution {
    public int climbStairs(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        int a = 1;
        int b = 2;
        int c = a + b;

        for (int i = 3; i < n; i++) {
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }
}
