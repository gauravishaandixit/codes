package codes.java.dp.unboundedknapsack;

public class RodCutting {

    int maxProfit(int[] prices, int length) {
        int n = prices.length;

        int[][] T = new int[n + 1][length + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= length; j++) {
                if (i <= j) {
                    T[i][j] = Math.max(T[i][j - i] + prices[i - 1], T[i - 1][j]);
                } else {
                    T[i][j] = T[i - 1][j];
                }
            }
        }
        return T[n][length];
    }

    public static void main(String[] ar) {
        int[] prices = new int[]{1, 3, 4};
        int length = 4;
        System.out.println(new RodCutting().maxProfit(prices, length));

        prices = new int[]{1, 3, 6};
        length = 5;
        System.out.println(new RodCutting().maxProfit(prices, length));

        prices = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        length = 8;
        System.out.println(new RodCutting().maxProfit(prices, length));
    }
}
