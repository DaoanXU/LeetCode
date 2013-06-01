package remove_duplicates_from_sorted_array_ii;

public class Solution {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0)
            return 0;

        int current = A[0];
        int last = 1;
        int count = 1;
        int maxCount = 2;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == current) {
                count++;
                if (count > maxCount)
                    continue;
                A[last] = A[i];
                last++;
            }
            else {
                count = 1;
                current = A[i];
                A[last] = A[i];
                last++;
            }
        }
        return last;
    }
}
