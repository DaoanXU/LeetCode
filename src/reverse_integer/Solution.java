package reverse_integer;

public class Solution {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE)
            throw new NumberFormatException("Can not revese" + x);
        boolean negative = x < 0;
        if (negative)
            x = -x;

        int radix = 10;
        int limit = Integer.MAX_VALUE / radix;
        int limitDigit = Integer.MAX_VALUE % radix;
        int result = 0;

        while (x > 0) {
            int digit = x % radix;
            x = x / radix;
            if(result > limit)
                throw new NumberFormatException("Can not revese" + x);
            if(result == limit && digit > limitDigit)
                throw new NumberFormatException("Can not revese" + x);            
            result = result * radix + digit;
        }

        return negative ? -result : result;
    }

}
