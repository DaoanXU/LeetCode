package two_sum;

import java.util.HashMap;

public class SolutionMap {
    public int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;
        HashMap<Integer, Integer> index = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for (int i = 0; i < length; i++) {
            if (index.containsKey(target - numbers[i])) {
                result[0] = index.get(target - numbers[i]).intValue() + 1;
                result[1] = i + 1;
                return result;
            }
            index.put(numbers[i], i);
        }
        return null;
    }
}
