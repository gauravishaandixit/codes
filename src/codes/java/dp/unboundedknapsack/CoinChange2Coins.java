package codes.java.dp.unboundedknapsack;

public class CoinChange2Coins {

    public static int coinChange1Ddp(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0)
            return -1;
        int[] minNumber = new int[amount + 1];
        for (int i = 1; i <= amount; i++)
        {
            minNumber[i] = Integer.MAX_VALUE;
            for (int coin : coins)
            {
                if (coin <= i && minNumber[i - coin] != Integer.MAX_VALUE)
                    minNumber[i] = Integer.min(minNumber[i], 1 + minNumber[i - coin]);
            }
        }

        return minNumber[amount] == Integer.MAX_VALUE ? -1 : minNumber[amount];
    }


    public static int coinChange2Ddp(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0)
            return -1;
        int[][] minNumber = new int[coins.length + 1][amount + 1];

        for(int i = 0; i <= amount; i++) {
            minNumber[0][i] = amount + 1;
        }

        for(int i = 0; i <= coins.length; i++) {
            minNumber[i][0] = 0;
        }

        for(int i = 1; i <= coins.length; i++) {
            for(int j = 1; j <= amount; j++) {
                if(coins[i - 1] > j) {
                    minNumber[i][j] = minNumber[i-1][j];
                }
                else {
                    minNumber[i][j] = Math.min(minNumber[i - 1][j], minNumber[i][j - coins[i - 1]]);
                }
            }
        }

        return minNumber[coins.length][amount] > amount ? -1 : minNumber[coins.length][amount];
    }
}
