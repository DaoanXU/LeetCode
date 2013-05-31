package sqrt;

public class SolutionBinarySearch {
    public int sqrt(int x) {

        int start = 0;
        int end = x;

        if (x == 1)
            return 1;
        if (x == 0)
            return 0;

        while (start < end - 1) {
            int half = (start + end) >>> 1;
            if (half < x / half)
                start = half;
            else
                end = half;
        }

        return start + 1 <= (x / (start + 1)) ? start + 1 : start;

    }
}
