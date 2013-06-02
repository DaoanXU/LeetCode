package search_in_rotated_sorted_array_ii;

public class Solution {

    public boolean search(int[] A, int target) {
        if (A[0] == target)
            return true;

        int first = 0;
        int last = A.length;
        if (A[0] == A[A.length - 1]) {
            while (first < last && A[0] == A[first])
                first++;
            while (first < last && A[0] == A[last - 1])
                last--;
        }
        return search(A, target, first, last) != -1;

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
