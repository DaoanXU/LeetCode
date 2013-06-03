package pascals_triangle;

import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int rowIndex) {

        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> result = new ArrayList<Integer>();

        if (rowIndex == 0)
            return results;

        result.add(1);
        results.add(new ArrayList<Integer>(result));
        while (rowIndex > 1) {

            int previous = 1;
            for (int i = 1; i < result.size(); i++) {
                int next = result.get(i);
                result.set(i, previous + next);
                previous = next;
            }
            result.add(1);

            results.add(new ArrayList<Integer>(result));
            rowIndex--;
        }
        return results;

    }
}