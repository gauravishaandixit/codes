package codes.java.dp.boundedknapsack;

public class KnapsackBottomUp {

    int maxProfit(int weight[], int profit[], int n, int W)
    {
        int T[][] = new int[n + 1][W + 1];
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= W; j++)
            {
                T[i][j] = T[i-1][j];
                if(weight[i-1] <= j)
                    T[i][j] = Math.max(profit[i - 1] + T[i-1][j - weight[i - 1]], T[i][j]);
            }
        }

        return T[n][W];
    }

    public static void main(String[] args)
    {
        int n = 5;
        int weight[] = new int[]{1, 2, 4, 5, 7};
        int profit[] = new int[]{5, 5, 6, 8, 3};
        int W = 7;

        System.out.println(new KnapSack01Recursive().maxProfit(weight, profit, n, W));
    }
}
