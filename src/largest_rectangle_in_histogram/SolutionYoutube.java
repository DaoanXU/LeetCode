package largest_rectangle_in_histogram;

import java.util.Stack;

public class SolutionYoutube {
    public int largestRectangleArea(int[] height) {

        Stack<Integer> heights = new Stack<Integer>();
        Stack<Integer> indexes = new Stack<Integer>();

        int LargestAres = 0;

        for (int i = 0; i < height.length; i++) {
            if (heights.isEmpty() || height[i] > heights.peek()) {
                heights.push(height[i]);
                indexes.push(i);
            }
            else if (height[i] < heights.peek()) {
                int lastIndex = 0;
                while (!heights.isEmpty() && height[i] < heights.peek()) {
                    lastIndex = indexes.pop();
                    int tempAreaSize = heights.pop() * (i - lastIndex);
                    if (LargestAres < tempAreaSize)
                        LargestAres = tempAreaSize;
                }
                heights.push(height[i]);
                indexes.push(lastIndex);
            }
        }

        while (!heights.isEmpty()) {
            int tempAreaSize = heights.pop() * (height.length - indexes.pop());
            if (LargestAres < tempAreaSize)
                LargestAres = tempAreaSize;
        }

        return LargestAres;
    }

}
