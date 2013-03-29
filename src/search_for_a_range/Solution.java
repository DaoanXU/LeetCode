package search_for_a_range;

public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] result = new int[2];
        result[0] = search(A, target, true);
        result[1] = search(A, target, false);
        return result;
    }

    public int search(int[] A, int target, boolean isLow) {
        int low = 0;
        int high = A.length - 1;

        while (low <= high) {
            if (low == high && A[low] == target)
                return low;

            int mid = isLow ? (low + high) >>> 1 : ((low + high) >>> 1) + ((low + high) & 1);
            int midVal = A[mid];

            if (midVal < target) {
                low = mid + 1;
            } else if (midVal > target) {
                high = mid - 1;
            } else {
                if (isLow)
                    high = mid;
                else
                    low = mid;
            }
        }

        return -1;
    }
}