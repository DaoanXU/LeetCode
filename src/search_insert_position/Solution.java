package search_insert_position;

public class Solution {
    public int searchInsert(int[] A, int target) {
        int low = 0;
        int high = A.length - 1;

        while (low <= high) {
            if (low == high) {
                if (A[low] >= target)
                    return low;
                return low + 1;
            }

            int mid = (low + high) >>> 1;
            int midVal = A[mid];

            if (midVal < target) {
                low = mid + 1;
            } else if (midVal > target) {
                high = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }
}