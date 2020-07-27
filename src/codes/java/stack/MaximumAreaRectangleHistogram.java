package codes.java.stack;

import java.util.ArrayList;
import java.util.Stack;

public class MaximumAreaRectangleHistogram {
    int largestRectangleArea(ArrayList<Integer> arr) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        int i = 0;
        int curr_area = 0;
        int n = arr.size();

        while(i < n)
        {
            if(st.isEmpty() || arr.get(i) >= arr.get(st.peek()))
                st.push(i++);
            else
            {
                int height = arr.get(st.pop());
                int width = (st.isEmpty()? i : i - st.peek() - 1);
                curr_area = height * width;
                ans = Math.max(ans, curr_area);
            }
        }
        while(!st.isEmpty())
        {
            int height = arr.get(st.pop());
            int width = (st.isEmpty()? n : n - st.peek() - 1);
            curr_area = height * width;
            ans = Math.max(ans, curr_area);
        }
        return ans;
    }
}
