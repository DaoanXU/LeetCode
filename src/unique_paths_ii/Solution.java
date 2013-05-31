package unique_paths_ii;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1)
                break;
            result[i] = 1;
        }

        for (int j = 1; j < m; j++) {
            if (obstacleGrid[j][0] == 1)
                result[0] = 0;
            for (int i = 1; i < n; i++) {
                if (obstacleGrid[j][i] == 1)
                    result[i] = 0;
                else
                    result[i] = result[i - 1] + result[i];
            }
        }
        return result[n - 1];
    }
}