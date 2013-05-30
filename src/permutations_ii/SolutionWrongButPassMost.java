package permutations_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class SolutionWrongButPassMost {
    private ArrayList<ArrayList<Integer>> result;

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        permuteHelper(num, 0);
        return result;
    }

    private void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    private void permuteHelper(int[] num, int left) {
        if (left == num.length - 1) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < num.length; i++) {
                list.add(num[i]);
            }
            result.add(list);
            return;
        }

        for (int right = left; right < num.length; right++) {
            if (left != right && num[left] == num[right])
                continue;
            if (left != right && num[right - 1] == num[right])
                continue;

            swap(num, left, right);
            Arrays.sort(num, left + 1, num.length);
            permuteHelper(num, left + 1);
            swap(num, left, right);
        }
    }
}