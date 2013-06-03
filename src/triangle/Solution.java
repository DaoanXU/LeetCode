package triangle;

import java.util.ArrayList;

public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int n = triangle.size();

        if (n == 0)
            return 0;

        int[] result = new int[n];
        for (int i = 0; i < n; i++)
            result[i] = triangle.get(n - 1).get(i);

        for (int j = n - 2; j > -1; j--) {
            for (int i = 0; i <= j; i++) {
                result[i] = Math.min(result[i], result[i + 1]) + triangle.get(j).get(i);
            }
        }

        return result[0];
    }
}
