package three_sum_closest;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author Daoan XU
 * 
 */
public class Solution {
    public int threeSumClosest(int[] num, int target) {
        int maxDiff = Integer.MAX_VALUE;
        int result = 0;
        Arrays.sort(num);

        for (int i = 0; i < num.length-2; i++) {
            int left = i + 1;
            int right = num.length - 1;
            while (left < right) {
                int sum = num[left] + num[right] + num[i];
                int diff = sum - target;
                int absDiff = Math.abs(diff);
                if (absDiff < maxDiff) {
                    maxDiff = absDiff;
                    result = sum;
                }
                if (diff > 0)
                    right--;
                else if (diff < 0)
                    left++;
                else {
                    return sum;
                }
            }
        }

        return result;
    }
}
