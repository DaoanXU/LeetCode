package search_in_rotated_sorted_array;

import java.util.Arrays;

public class Solution {

    public int search(int[] A, int target) {
        return search(A, target, 0, A.length);
    }

    public int search(int[] A, int key, int fromIndex, int toIndex) {

        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int lowVal = A[low];
            int highVal = A[high];

            int mid = (low + high) >>> 1;
            int midVal = A[mid];

            if (key == midVal)
                return mid;

            if (midVal >= lowVal) {
                if (key > midVal) {
                    low = mid + 1;
                } else {
                    if (key < lowVal)
                        low = mid + 1;
                    else
                        high = mid - 1;
                }
            } else {
                if (key > midVal) {
                    if (key > highVal)
                        high = mid - 1;
                    else
                        low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
