package three_sum;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This solution is O(N^2)
 * However, it reaches the time limit.
 * 
 * @author Daoan XU
 * 
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {

        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < num.length; i++) {
            if (i < 0)
                break;
            int left = i + 1;
            int right = num.length - 1;
            while (left < right) {
                int sum = num[left] + num[right] + num[i];
                if (sum > 0)
                    right--;
                else if (sum < 0)
                    left++;
                else {
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(num[i]);
                    tmp.add(num[left]);
                    tmp.add(num[right]);
                    addToList(result, tmp);
                    right--;
                    left++;
                    continue;
                }
            }
        }

        return result;
    }

    void addToList(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> tmp) {
        int size = result.size();
        for (int i = 0; i < size; i++)
            if (isSame(result.get(i), tmp))
                return;
        result.add(tmp);
    }

    <T extends Comparable<T>> boolean isSame(ArrayList<T> a, ArrayList<T> b) {
        int size = a.size();
        for (int i = 0; i < size; i++) {
            if (a.get(i) != b.get(i))
                return false;
        }
        return true;
    }
}
