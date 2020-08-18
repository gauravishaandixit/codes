package codes.java.stack;

import java.util.Stack;

public class OnlineStockSpan {
    private int[] onlineStockSpan(int[] prices)
    {
        int n = prices.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = n - 1; i >= 0; i--)
        {
            while(!stack.isEmpty() && prices[stack.peek()] <= prices[i])
            {
                ans[stack.peek()] = stack.pop() - i;
            }
            stack.push(i);
        }
        while(!stack.isEmpty())
            ans[stack.peek()] = stack.pop() + 1;
        return ans;
    }

    public static void main(String[] ar)
    {
        int[] prices = new int[]{100, 80, 60, 70, 60, 75, 85};
        int[] ans = new OnlineStockSpan().onlineStockSpan(prices);
        for(int a: ans)
            System.out.print(a + " ");

        System.out.println();
        prices = new int[]{100, 80, 60, 70, 60, 75, 110};
        ans = new OnlineStockSpan().onlineStockSpan(prices);
        for(int a: ans)
            System.out.print(a + " ");

        System.out.println();
        prices = new int[]{7, 6, 5, 4, 3, 2, 1};
        ans = new OnlineStockSpan().onlineStockSpan(prices);
        for(int a: ans)
            System.out.print(a + " ");

    }
}
