package four_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Idea:
 * 1: find all 2 tuples sum.
 * 2: find all 2 that sums to the target.
 * 
 * Average case should be O(N^2LogN)
 * The Worst case is O(N^4)
 * This passes the online test
 * 
 * @author Daoan XU
 * 
 */
public class Solution {
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
        Arrays.sort(twoSums);

        int left = 0;
        int right = twoSumsSize - 1;

        while (left < right) {
            int sum = twoSums[left].sum + twoSums[right].sum - target;
            if (sum > 0)
                right--;
            else if (sum < 0)
                left++;
            else {
                int first = left;
                int last = right;
                LinkedList<ValueIndexPair> lefts = new LinkedList<ValueIndexPair>();
                LinkedList<ValueIndexPair> rights = new LinkedList<ValueIndexPair>();
                while (left < twoSumsSize && twoSums[left].sum == twoSums[first].sum) {
                    lefts.add(twoSums[left]);
                    left++;
                }
                while (right > -1 && twoSums[right].sum == twoSums[last].sum) {
                    rights.add(twoSums[right]);
                    right--;
                }

                for (ValueIndexPair ii : lefts) {
                    for (ValueIndexPair jj : rights) {
                        if(ii.conflict(jj))
                            continue;
                        ArrayList<Integer> tmp = getValues(num, ii, jj);
                        if (set.add(tmp))
                            result.add(tmp);
                    }
                }
            }

        }

        return result;
    }

    private ArrayList<Integer> getValues(int[] num, ValueIndexPair i, ValueIndexPair j) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int[] arr = new int[] { num[i.index1], num[i.index2], num[j.index1], num[j.index2] };
        Arrays.sort(arr);
        result.add(arr[0]);
        result.add(arr[1]);
        result.add(arr[2]);
        result.add(arr[3]);
        return result;
    }

}
