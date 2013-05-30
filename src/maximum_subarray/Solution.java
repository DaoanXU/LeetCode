package maximum_subarray;

public class Solution {
    public int maxSubArray(int[] A) {

        int sum = 0;
        int[] B = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            B[i] = sum;
            sum = sum + A[i];
        }
        B[A.length] = sum;
        return maxDiffArray(B);
    }

    int maxDiffArray(int[] A) {
        int buy = 0;
        int sell = 1;
        int max = A[sell] - A[buy];
        while (sell < A.length) {
            max = Math.max(A[sell] - A[buy], max);
            if (A[sell] < A[buy])
                buy = sell;
            sell++;
        }

        return max;
    }
}