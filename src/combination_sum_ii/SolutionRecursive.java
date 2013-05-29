package combination_sum_ii;

import java.util.ArrayList;
import java.util.Arrays;

public class SolutionRecursive {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return helper(candidates, 0, target);
    }

    private ArrayList<ArrayList<Integer>> helper(int[] candidates, int from, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (target == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        for (int i = from; i < candidates.length && candidates[i] <= target; i++) {
            addTo(result, helper(candidates, i, target - candidates[i]), candidates[i]);
        }
        return result;
    }

    private void addTo(ArrayList<ArrayList<Integer>> result, ArrayList<ArrayList<Integer>> helper, int i) {
        for (ArrayList<Integer> list : helper) {
            list.add(0, i);
            result.add(list);
        }
    }
}
