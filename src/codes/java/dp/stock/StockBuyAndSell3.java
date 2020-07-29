package codes.java.dp.stock;


// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/


public class StockBuyAndSell3 {
    public int maxProfit(int[] prices) {

        if(prices.length == 0)
            return 0;
        int T[][] = new int[3][prices.length];

        for (int i = 1; i < T.length; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < T[0].length; j++) {
                T[i][j] = Math.max(T[i][j-1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, T[i-1][j] - prices[j]);
            }
        }
        return T[2][prices.length-1];

    }
}
