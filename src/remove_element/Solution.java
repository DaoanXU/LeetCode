package remove_element;

public class Solution {
    public int removeElement(int[] A, int elem) {
        
        if (A == null || A.length == 0)
            return 0;

        int step = 0;
        for (int i = 0; i < A.length; i++) {
            if(A[i] == elem)
                step ++ ;
            else
                A[i -step] = A[i];
        }
        return A.length - step;
        
    }
}