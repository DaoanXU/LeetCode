package plus_one;

public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int index = digits.length - 1;
        while (index >= 0) {
            digits[index] = digits[index] + carry;
            carry = digits[index] / 10;
            digits[index] %= 10;
            index--;
            if (carry == 0)
                return digits;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;
        for (int i = 0; i < digits.length; i++) {
            result[i + 1] = digits[i];
        }
        return result;
    }
}
