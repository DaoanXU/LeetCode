package search_a_2d_matrix;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int low;
        int high;
        int mid;

        low = 0;
        high = matrix.length - 1;
        while (low <= high) {
            mid = (low + high) >>> 1;
            int value = matrix[mid][0];
            if (target < value)
                high = mid - 1;
            else if (target > value)
                low = mid + 1;
            else
                return true;
        }

        if (low == 0)
            return false;

        int[] arr = matrix[low - 1];
        low = 0;
        high = arr.length - 1;
        while (low <= high) {
            mid = (low + high) >>> 1;
            int value = arr[mid];
            if (target < value)
                high = mid - 1;
            else if (target > value)
                low = mid + 1;
            else
                return true;
        }
        return false;
    }
}
