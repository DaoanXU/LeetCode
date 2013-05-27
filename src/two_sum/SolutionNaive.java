package two_sum;

public class SolutionNaive {

    public int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;
        int[] result = new int[2];
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                    return result;
                }
            }
        }
        return null;
    }

}
