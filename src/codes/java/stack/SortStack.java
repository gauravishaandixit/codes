package codes.java.stack;

import java.util.Stack;

public class SortStack {

    void sortStack(Stack<Integer> stack)
    {
        if(!stack.isEmpty())
        {
            int x = stack.pop();
            sortStack(stack);
            sortedInsert(stack, x);
        }
    }

    void sortedInsert(Stack<Integer> stack, int x)
    {
        if(stack.isEmpty() || x >= stack.peek())
        {
            stack.push(x);
            return;
        }

        int top = stack.pop();
        sortedInsert(stack, x);
        stack.push(top);
    }

    public static void main(String[] args)
    {
        Stack<Integer> st = new Stack<>();
        st.push(5);
        st.push(4);
        st.push(3);
        st.push(2);
        st.push(1);

        System.out.println(st);
        new SortStack().sortStack(st);
        System.out.println(st);
    }
}
