package codes.java.stack;

import java.util.Arrays;
import java.util.Stack;

public class MaxRectangleAreaMatrix {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;

        int col = matrix[0].length;

        int[] heights = new int[col];
        Arrays.fill(heights, 0);
        int maxRect = -1;

        for (char[] chars : matrix) {
            for (int j = 0; j < col; j++) {
                if (chars[j] == '1')
                    heights[j] = heights[j] + 1;
                else
                    heights[j] = 0;

            }
            maxRect = Math.max(maxRect, maxArea(heights));
        }

        return maxRect;
    }

    private int maxArea(int[] heights) {
        int max = -1;
        Stack<Integer> s = new Stack<>();

        int len = heights.length;
        int i = 0;
        while (i < len) {
            if (s.isEmpty() || heights[i] >= heights[s.peek()])
                s.push(i++);
            else {
                int height = heights[s.pop()];
                int width = s.isEmpty() ? i : i - s.peek() - 1;
                max = Math.max(max, height * width);
            }

        }

        while (!s.isEmpty()) {
            int height = heights[s.pop()];
            int width = s.isEmpty() ? len : len - s.peek() - 1;
            max = Math.max(max, height * width);
        }
        return max;
    }
}
