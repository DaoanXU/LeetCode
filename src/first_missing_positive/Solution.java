package first_missing_positive;

public class Solution {
    public int firstMissingPositive(int[] A) {
        for (int i = 0; i < A.length; i++) {
            while (A[i] != i + 1
                    && A[i] > 0 && A[i] <= A.length
                    && A[i] != A[A[i] - 1]) {
                int temp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = temp;
            }
        }

        int i = 0;
        while (i < A.length && A[i] == i + 1)
            i++;
        return i + 1;
    }
    
    public static void main(String[] args) {
        new Solution().firstMissingPositive(new int[]{2,1});
    }
}
