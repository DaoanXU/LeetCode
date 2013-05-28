package container_with_most_water;

public class Solution {
    public int maxArea(int[] height) {
        return maxArea2(height, 0, height.length - 1, 0);
    }

    public int maxArea(int[] height, int start, int end, int max) {
        if (start == end)
            return max;

        int thisArea = Math.min(height[start], height[end]) * (end - start);
        if (thisArea > max)
            max = thisArea;
        if (height[start] > height[end])
            return maxArea(height, start, end - 1, max);
        return maxArea(height, start + 1, end, max);
    }

    public int maxArea2(int[] height, int start, int end, int max) {
        while (end > start) {
            int thisArea = Math.min(height[start], height[end]) * (end - start);
            if (thisArea > max)
                max = thisArea;
            if (height[start] > height[end])
                end--;
            else
                start++;
        }
        return max;
    }
}
