package unique_bianry_search_trees;

import java.util.ArrayList;

public class Solution {
    static ArrayList<Integer> result;
    static {
        result = new ArrayList<Integer>();
        result.add(1);
        result.add(1);
        result.add(2);
    }

    public int numTrees(int n) {
        if (n < result.size())
            return result.get(n);

        int temp = 0;
        for (int i = 0; i < n; i++) {
            temp += numTrees(i) * numTrees(n - 1 - i);
        }
        result.add(temp);
        return temp;
    }
}