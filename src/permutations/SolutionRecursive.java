package permutations;

import java.util.ArrayList;
import java.util.Arrays;

public class SolutionRecursive {
    private ArrayList<ArrayList<Integer>> result;
    int[] num;
    boolean[] used;
    int[] ans;

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        this.num = num;
        used = new boolean[num.length];
        ans = new int[num.length];
        permuteHelper(0);
        return result;
    }

    private void permuteHelper(int size) {
        if (size == num.length) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < num.length; i++) {
                list.add(ans[i]);
            }
            result.add(list);
            return;
        }

        for (int i = 0; i < num.length; i++) {
            if (used[i])
                continue;

            used[i] = true;
            ans[size] = num[i];
            permuteHelper(size + 1);
            used[i] = false;
        }

    }

}