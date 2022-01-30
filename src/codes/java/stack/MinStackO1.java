package codes.java.stack;

import java.util.Stack;

public class MinStackO1 {

    Stack<Integer> stack;
    int minEle;

    MinStackO1() {
        stack = new Stack<>();
        minEle = Integer.MAX_VALUE;
    }

    void push(int x) {
        if (stack.isEmpty()) {
            minEle = x;
            stack.push(x);
            return;
        }
        if (x >= minEle)
            stack.push(x);
        else {
            stack.push(2 * x - minEle);
            minEle = x;
        }
    }

    int pop() {
        if (stack.isEmpty())
            return Integer.MAX_VALUE;

        int top = stack.pop();
        if (top < minEle) {
            int x = minEle;
            minEle = 2 * minEle - top;
            return x;
        } else
            return top;
    }

    int peek() {
        if (stack.isEmpty())
            return Integer.MAX_VALUE;

        int top = stack.peek();
        return Math.max(top, minEle);
    }

    int getMin() {
        return minEle;
    }

    public static void main(String[] ar) {
        MinStackO1 minStackO1 = new MinStackO1();

        minStackO1.push(1);
        System.out.println(minStackO1.getMin());

        minStackO1.push(2);
        System.out.println(minStackO1.getMin());

        minStackO1.push(0);
        System.out.println(minStackO1.getMin());

        minStackO1.push(-1);
        System.out.println(minStackO1.getMin());

        minStackO1.push(0);
        System.out.println(minStackO1.getMin());

        System.out.println(minStackO1.stack);

        System.out.println(minStackO1.peek());
        System.out.println(minStackO1.pop());
        System.out.println(minStackO1.getMin());
    }
}
