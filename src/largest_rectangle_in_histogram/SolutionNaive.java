package largest_rectangle_in_histogram;

public class SolutionNaive {

    int[] height;

    public int largestRectangleArea(int[] height) {
        this.height = height;
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            max = Math.max(max, getWidth(i) * height[i]);
        }
        return max;
    }

    int getWidth(int index) {
        int count = 1;
        for (int i = index - 1; i > -1; i--) {
            if (height[i] >= height[index])
                count++;
            else
                break;
        }

        for (int i = index + 1; i < height.length; i++) {
            if (height[i] >= height[index])
                count++;
            else
                break;
        }
        return count;
    }
}
