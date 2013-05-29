package combination_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class SolutionRecursive {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<ArrayList<Integer>> result = helper(candidates, 0, target);
        result = removeDuplicated(result);
        return result;
    }

    private ArrayList<ArrayList<Integer>> removeDuplicated(ArrayList<ArrayList<Integer>> input) {
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for(ArrayList<Integer> o : input){
            if(set.add(o))
                result.add(o);
        }
        return result;
    }

    private ArrayList<ArrayList<Integer>> helper(int[] candidates, int from, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (target == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        for (int i = from; i < candidates.length && candidates[i] <= target; i++) {
            addTo(result, helper(candidates, i + 1, target - candidates[i]), candidates[i]);
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
