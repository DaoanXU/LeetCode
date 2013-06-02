package trapping_rain_water;

public class SolutionRowByRow {

    public int trap(int[] A) {
        int result = 0;
        int bot = 0;
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > max)
                max = A[i];
        }

        while (max > bot) {
            //Count row by row from the bottom
            int first = -1;
            int last = 0;
            int count = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < A.length; i++) {
                if (A[i] > bot) {
                    last = i;
                    count++;
                    if (first == -1)
                        first = i;
                    if (min > A[i])
                        min = A[i];
                }
            }
            result += (min - bot) * (last - first + 1 - count);
            bot = min;
        }

        return result;
    }
    
}
