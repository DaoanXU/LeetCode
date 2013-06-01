package subsets;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    ArrayList<ArrayList<Integer>> result;

    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());

        Arrays.sort(S);
        for (int i = 0; i < S.length; i++) {
            put(S[i]);
        }
        return result;
    }

    void put(int it) {
        int size = result.size();
        for (int i = 0; i < size; i++) {
            ArrayList<Integer> newOne = new ArrayList<Integer>(result.get(i));
            newOne.add(it);
            result.add(newOne);
        }
    }
}
