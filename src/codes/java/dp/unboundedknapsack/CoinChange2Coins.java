package codes.java.dp.unboundedknapsack;

public class CoinChange2Coins {

    public static int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0)
            return 0;
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

}
