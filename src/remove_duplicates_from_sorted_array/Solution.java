package remove_duplicates_from_sorted_array;

public class Solution {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0)
            return 0;

        int current = A[0];
        int step = 0;
        for (int i = 1; i < A.length; i++) {
            if(A[i] == current)
                step ++ ;
            else{
                A[i -step] = A[i];
                current = A[i];
            }
        }
        return A.length - step;
    }
}
