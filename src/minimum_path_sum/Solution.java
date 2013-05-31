package minimum_path_sum;

public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] answer = new int[n];
        answer[0] = grid[0][0];
        for (int i = 1; i < n; i++)
            answer[i] = grid[0][i] + answer[i - 1];

        for (int j = 1; j < m; j++) {
            answer[0] = grid[j][0] + answer[0];
            for (int i = 1; i < n; i++) {
                answer[i] = Math.min(answer[i], answer[i - 1])
                        + grid[j][i];
            }
        }

        return answer[n - 1];
    }
}