package codes.java.dp.stock;

import java.util.Arrays;

public class StockBuyAndSellCoolDown {

    public int maxProfit(int[] prices) {

        int[][] memo = new int[2][prices.length];

        for(int[] m: memo)
            Arrays.fill(m, -1);

        return maxProfit(prices, 0, 0, memo); // choice zero for buying and 1 for selling, initially we want to buy

    }

    int maxProfit(int[] prices, int index, int choice, int[][] memo)
    {
        if(index >= prices.length)
            return 0;

        if(memo[choice][index] != -1)
            return memo[choice][index];

        int currProfit = 0;

        if(choice == 0) // buy
        {
            int buy = maxProfit(prices, index + 1, 1 - choice, memo) - prices[index];
            int noBuy = maxProfit(prices, index + 1, choice, memo);

            currProfit = Math.max(buy, noBuy);
        }
        else
        {
            int sell = maxProfit(prices, index + 2, 1 - choice, memo) + prices[index];
            int noSell = maxProfit(prices, index + 1, choice, memo);

            currProfit = Math.max(sell, noSell);
        }

        return memo[choice][index] = currProfit;
    }
}
