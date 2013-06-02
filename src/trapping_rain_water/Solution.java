package trapping_rain_water;

public class Solution {
    public int trap(int[] A) {
        if (A.length < 3)
            return 0;

        int[] leftMax = new int[A.length];
        for (int i = 1; i < A.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], A[i - 1]);
        }

        int rightMax = 0;
        int count = 0;
        for (int i = A.length - 2; i > 0; i--) {
            rightMax = Math.max(rightMax, A[i + 1]);
            count = count + Math.max(Math.min(rightMax, leftMax[i]) - A[i], 0);
        }
        return count;
    }
}
