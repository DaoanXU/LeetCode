package subsets_ii;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    ArrayList<ArrayList<Integer>> result;

    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
        result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());

        Arrays.sort(S);

        if ((S.length) == 0)
            return result;

        put(S[0], 1);

        Arrays.sort(S);
        int range = result.size() - 1;
        for (int i = 1; i < S.length; i++) {
            if (S[i] != S[i - 1])
                range = result.size();
            put(S[i], range);
        }
        return result;
    }

    void put(int it, int range) {
        int size = result.size();
        for (int i = size - range; i < size; i++) {
            ArrayList<Integer> newOne = new ArrayList<Integer>(result.get(i));
            newOne.add(it);
            result.add(newOne);
        }
    }
}