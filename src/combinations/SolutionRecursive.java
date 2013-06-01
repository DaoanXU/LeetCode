package combinations;

import java.util.ArrayList;

public class SolutionRecursive {

    private ArrayList<ArrayList<Integer>> result;
    int[] num;
    boolean[] used;
    int[] ans;
    int k;

    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        this.k = k;
        this.num = new int[n];
        this.ans = new int[k];
        this.used = new boolean[n];
        this.result = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            num[i] = i + 1;
        }
        permuteHelper(0, 0);
        return result;
    }

    private void permuteHelper(int size, int usedIndex) {
        if (size == k) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < ans.length; i++) {
                list.add(ans[i]);
            }
            result.add(list);
            return;
        }

        for (int i = usedIndex; i < num.length; i++) {
            if (used[i])
                continue;

            used[i] = true;
            ans[size] = num[i];
            permuteHelper(size + 1, i + 1);
            used[i] = false;
        }

    }
}