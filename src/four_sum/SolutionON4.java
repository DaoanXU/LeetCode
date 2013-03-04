package four_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Idea:
 * 1: find all 2 tuples sum.
 * 2: find all 2 that sums to the target.
 * 
 * This one is O(N^4), Can not Pass
 * 
 * @author Daoan XU
 * 
 */


public class SolutionON4 {
    class ValueIndexPair implements Comparable<ValueIndexPair> {
        int sum;
        int index1;
        int index2;

        public boolean conflict(ValueIndexPair in) {
            return index1 == in.index1 || index1 == in.index2 || index2 == in.index1
                    || index2 == in.index2;
        }
        
        @Override
        public int compareTo(ValueIndexPair o) {
            return sum < o.sum ? -1 : (sum > o.sum ? 1 : 0);
        }
    }
    
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int size = num.length;

        ValueIndexPair[] twoSums = new ValueIndexPair[(size - 1) * size / 2];
        int twoSumsSize = 0;

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                twoSums[twoSumsSize] = new ValueIndexPair();
                twoSums[twoSumsSize].sum = num[i] + num[j];
                twoSums[twoSumsSize].index1 = i;
                twoSums[twoSumsSize].index2 = j;
                twoSumsSize++;
            }
        }
       

        Set set = new HashSet();
        for (int i = 0; i < twoSumsSize; i++) {
            for (int j = i + 1; j < twoSumsSize; j++) {
                if (twoSums[i].sum + twoSums[j].sum == target && !twoSums[i].conflict(twoSums[j])) {
                    ArrayList<Integer> tmp = addFour(num[twoSums[i].index1],
                            num[twoSums[i].index2], num[twoSums[j].index1], num[twoSums[j].index2]);
                    if (set.add(tmp))
                        result.add(tmp);
                }
            }
        }
        
        return result;
    }

    private ArrayList<Integer> addFour(int a, int b, int c, int d) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int[] arr = new int[] { a, b, c, d };
        Arrays.sort(arr);
        result.add(arr[0]);
        result.add(arr[1]);
        result.add(arr[2]);
        result.add(arr[3]);
        return result;
    }
}
