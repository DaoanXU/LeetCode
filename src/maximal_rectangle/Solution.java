package maximal_rectangle;

import java.util.Stack;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0)
            return 0;
        int n = matrix[0].length;

        int[][] arr = new int[m][n];
        for (int j = 0; j < n; j++)
            if (matrix[0][j] == '1')
                arr[0][j] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    arr[i][j] = arr[i - 1][j] + 1;
                }
                else {
                    arr[i][j] = 0;
                }
            }
        }

        int max = 0;

        for (int[] it : arr) {
            max = Math.max(max, largestRectangleArea(it));
        }

        return max;

    }

    class intStack {
        private int[] arr;
        private int size;

        intStack(int max) {
            arr = new int[max];
            size = 0;
        }

        int pop() {
            size = size - 1;
            return arr[size];
        }

        int peek() {
            return arr[size - 1];
        }

        boolean isEmpty() {
            return (size == 0);
        }

        void push(int x) {
            arr[size] = x;
            size = size + 1;
        }
    }

    public int largestRectangleArea(int[] height) {

        intStack heights = new intStack(height.length);
        intStack indexes = new intStack(height.length);

        int LargestAres = 0;

        for (int i = 0; i < height.length; i++) {
            if (heights.isEmpty() || height[i] > heights.peek()) {
                heights.push(height[i]);
                indexes.push(i);
            }
            else if (height[i] < heights.peek()) {
                int lastIndex = 0;
                while (!heights.isEmpty() && height[i] < heights.peek()) {
                    lastIndex = indexes.pop();
                    int tempAreaSize = heights.pop() * (i - lastIndex);
                    if (LargestAres < tempAreaSize)
                        LargestAres = tempAreaSize;
                }
                heights.push(height[i]);
                indexes.push(lastIndex);
            }
        }

        while (!heights.isEmpty()) {
            int tempAreaSize = heights.pop() * (height.length - indexes.pop());
            if (LargestAres < tempAreaSize)
                LargestAres = tempAreaSize;
        }

        return LargestAres;
    }
}
