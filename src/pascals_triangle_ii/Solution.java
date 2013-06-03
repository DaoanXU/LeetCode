package pascals_triangle_ii;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {

        ArrayList<Integer> result = new ArrayList<Integer>();

        result.add(1);
        while (rowIndex > 0) {

            int previous = 1;
            for (int i = 1; i < result.size(); i++) {
                int next = result.get(i);
                result.set(i, previous + next);
                previous = next;
            }
            result.add(1);

            rowIndex--;
        }
        return result;
    }
}