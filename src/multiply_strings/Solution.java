package multiply_strings;

public class Solution {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";

        int[] n1 = new int[num1.length()];
        int[] n2 = new int[num2.length()];
        int[] result = new int[n1.length + n2.length];

        for (int i = 0; i < n1.length; i++)
            n1[i] = num1.charAt(n1.length - 1 - i) - '0';
        for (int i = 0; i < n2.length; i++)
            n2[i] = num2.charAt(n2.length - 1 - i) - '0';

        for (int i = 0; i < n1.length; i++) {
            for (int j = 0; j < n2.length; j++) {
                result[i + j] += n1[i] * n2[j];
            }
        }

        for (int i = 0; i < result.length - 1; i++) {
            result[i + 1] += result[i] / 10;
            result[i] = result[i] % 10;
        }

        StringBuilder sb = new StringBuilder();
        int i;
        if (result[result.length - 1] == 0)
            i = result.length - 2;
        else
            i = result.length - 1;
        for (; i > -1; i--)
            sb.append(result[i]);

        return sb.toString();
    }
}
