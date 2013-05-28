package string_to_integer;

public class Solution {
    public int atoi(String str) {

        int size = str.length();

        if (str == null || size == 0)
            return 0;

        boolean negative = false;
        int limit = Integer.MAX_VALUE / 10;
        int limitDigit = Integer.MAX_VALUE % 10;
        int start = 0;

        limitDigit = Integer.MAX_VALUE % 10;

        while (str.charAt(start) == ' ' && start < size)
            start++;
        if (start == size)
            return 0;

        char firstDigit = str.charAt(start);
        if (firstDigit == '-') {
            negative = true;
            limit = Integer.MAX_VALUE / 10;
            limitDigit = Integer.MAX_VALUE % 10 + 1;
            start++;
        } else if (firstDigit == '+') {
            start++;
        }

        if (size == start)
            return 0;

        int result = 0;
        for (int i = start; i < size; i++) {
            int digit = str.charAt(i) - '0';
            if (digit < 0 || digit > 9)
                return negative ? -result : result;
            if (result > limit)
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            if (result == limit && digit > limitDigit)
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            result = result * 10 + digit;
        }

        return negative ? -result : result;
    }
}
