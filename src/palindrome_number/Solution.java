package palindrome_number;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x == 0)
            return true;

        int digits = 1;
        while (x / digits >= 10)
            digits = digits * 10;
        while (x > 0) {
            if (x / digits != x % 10)
                return false;
            x %= digits;
            x /= 10;
            digits /= 100;
        }
        return true;
    }
}