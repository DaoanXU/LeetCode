package sort_colors;

public class Solution {
    public void sortColors(int[] A) {
        int left = 0;
        int right = A.length - 1;
        int current = 0;

        while (current <= right) {
            if (A[current] == 0) {
                swap(A, current, left);
                left++;
                current++;
            }
            else if (A[current] == 2) {
                swap(A, current, right);
                right--;
            }
            else {
                current++;
            }
        }

    }

    void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}