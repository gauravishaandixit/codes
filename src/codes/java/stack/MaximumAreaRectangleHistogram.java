package codes.java.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class MaximumAreaRectangleHistogram {
    int largestRectangleArea(ArrayList<Integer> arr) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        int i = 0;
        int curr_area;
        int n = arr.size();

        while (i < n) {
            if (st.isEmpty() || arr.get(st.peek()) <= arr.get(i)) {
                st.push(i++);
            } else {
                int height = arr.get(st.pop());
                int width = (st.isEmpty() ? i : i - st.peek() - 1);
                curr_area = height * width;
                ans = Math.max(ans, curr_area);
            }
        }
        while (!st.isEmpty()) {
            int height = arr.get(st.pop());
            int width = (st.isEmpty() ? n : n - st.peek() - 1);
            curr_area = height * width;
            ans = Math.max(ans, curr_area);
        }
        return ans;
    }

    public int[] nextSmallerRight(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (st.size() > 0 && arr[st.peek()] > arr[i]) {
                res[st.pop()] = i;
            }
            st.push(i);
        }
        while (st.size() > 0) {
            res[st.pop()] = arr.length;
        }
        return res;
    }

    public int[] nextSmallerLeft(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (st.size() > 0 && arr[st.peek()] > arr[i]) {
                res[st.pop()] = i;
            }
            st.push(i);
        }
        while (st.size() > 0) {
            res[st.pop()] = -1;
        }

        return res;
    }

    public int largestRectangleArea(int[] heights) {
        int[] nsr = nextSmallerRight(heights);
        int[] nsl = nextSmallerLeft(heights);
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max, (nsr[i] - nsl[i] - 1) * heights[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumAreaRectangleHistogram().largestRectangleArea(new ArrayList<>(Arrays.asList(5, 6, 3, 2, 4, 1))));
        System.out.println(new MaximumAreaRectangleHistogram().largestRectangleArea(new ArrayList<>(Arrays.asList(5, 6, 7, 2, 4, 8))));
        System.out.println(new MaximumAreaRectangleHistogram().largestRectangleArea(new ArrayList<>(Arrays.asList(3, 2, 3, 8, 4, 1))));
    }
}
