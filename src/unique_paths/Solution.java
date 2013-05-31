package unique_paths;

import java.util.Arrays;

public class Solution {
    public int uniquePaths(int m, int n) {
        if (n == 1)
            return 1;
        if (m == 1)
            return 1;

        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        for (int j = 1; j < m; j++) {
            for (int i = 1; i < n; i++) {
                arr[i] = arr[i - 1] + arr[i];
            }
        }
        return arr[n - 1];
    }
}