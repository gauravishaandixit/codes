package codes.java.dp.boundedknapsack;

import java.util.Arrays;
//Top Down
public class KnapsackMemo {
    int maxProfit(int weight[], int profit[], int n, int W, int memo[][])
    {
        if(n == 0 || W == 0)
            return 0;

        if(memo[n][W] != -1)
            return memo[n][W];

        if(weight[n-1] <= W)
            return memo[n][W] = Math.max(profit[n-1] + maxProfit(weight, profit, n - 1, W - weight[n-1], memo),
                    maxProfit(weight, profit, n - 1, W, memo));
        else
            return memo[n][W] = maxProfit(weight, profit, n - 1, W, memo);
    }

    public static void main(String[] args)
    {
        int n = 5;
        int weight[] = new int[]{1, 2, 4, 5, 7};
        int profit[] = new int[]{10, 5, 9, 8, 3};
        int W = 7;

        int memo[][] = new int[n + 1][W + 1];
        for(int i = 0; i <= n; i++)
            Arrays.fill(memo[i], -1);
        System.out.println(new KnapsackMemo().maxProfit(weight, profit, n, W, memo));
    }
}
