package integer_to_roman;

public class Solution {

    final int[] numbers = new int[] { 1, 5, 10, 50, 100, 500, 1000 };
    final int[] minuses = new int[] { 0, 1, 1, 10, 10, 100, 100 };
    final char[] romans = new char[] { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
    final char[] romansminus = new char[] { 0, 'I', 'I', 'X', 'X', 'C', 'C' };

    public String intToRoman(int num) {

        StringBuffer result = new StringBuffer();
        int step = numbers.length - 1;
        while (num > 0) {
            if (num < numbers[step] - minuses[step]) {
                step--;
                continue;
            }
            
            if(num < numbers[step]){
                result.append(romansminus[step]);
                result.append(romans[step]);
                num = num - numbers[step] + minuses[step];
                continue;
            }
            
            result.append(romans[step]);
            num = num - numbers[step];

        }
        return result.toString();
    }
}