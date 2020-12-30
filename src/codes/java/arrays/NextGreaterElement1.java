package codes.java.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// https://leetcode.com/problems/next-greater-element-i

public class NextGreaterElement1 {

    int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for(int num: nums2)
        {
            while(!st.isEmpty() && st.peek() < num)
                map.put(st.pop(), num);

            st.push(num);
        }

        for(int i = 0; i < nums1.length; i++)
            nums1[i] = map.getOrDefault(nums1[i], -1);

        return nums1;
    }

    public int[] nextGreaterElement_1(int[] findNums, int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = nums.length - 1; i >= 0; i--)
        {
            while(!stack.empty() && nums[i]>stack.peek())
                stack.pop();

            map.put(nums[i], (stack.empty())? -1 : stack.peek());
            stack.push(nums[i]);
        }
        for(int i = 0; i < findNums.length; i++)
            findNums[i] = map.get(findNums[i]);

        return findNums;
    }

}
