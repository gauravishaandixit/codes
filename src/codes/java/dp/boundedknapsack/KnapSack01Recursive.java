package codes.java.dp.boundedknapsack;

public class KnapSack01Recursive {

    int maxProfit(int[] weight, int[] profit, int n, int W)
    {
        if(n == 0 || W == 0)
            return 0;

        if(weight[n-1] <= W)
            return Math.max(profit[n-1] + maxProfit(weight, profit, n - 1, W - weight[n-1]),
                    maxProfit(weight, profit, n - 1, W ));
        else
            return maxProfit(weight, profit, n - 1, W);
    }

    public static void main(String[] args)
    {
        int n = 5;
        int[] weight = new int[]{1, 2, 4, 5, 7};
        int[] profit = new int[]{10, 5, 9, 8, 3};
        int W = 7;

        System.out.println(new KnapSack01Recursive().maxProfit(weight, profit, n, W));
    }
}
