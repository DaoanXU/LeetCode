package maximum_subarray;

public class Solution2 {

    public int maxSubArray(int[] A) {

        int max = A[0];
        int sum = 0;
        for (int sell = 0; sell < A.length; sell++) {
            sum = sum + A[sell];
            max = Math.max(sum, max);
            if (sum < 0)
                sum = 0;
        }
        return max;
    }
}
