package codes.java.arrays;

// https://leetcode.com/problems/next-greater-element-ii/

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2 {
    int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < 2 * n; i++)
        {
            while(!st.isEmpty() && nums[st.peek()] < nums[i % n])
                ans[st.pop()] = nums[i % n];

            st.push(i % n);
        }

        return ans;
    }
}
