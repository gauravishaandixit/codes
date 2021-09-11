package codes.java.dp.unboundedknapsack;

// No of ways to make the given amount from given array of coins

import java.util.Arrays;

public class CoinChange1Ways {

    public int noOfWays(int[] coins, int amount) {
        int n = coins.length;
        int[][] T = new int[n + 1][amount + 1];

        for(int i = 0; i <= n; i++)
            T[i][0] = 0;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= amount; j++) {
                if(coins[i - 1] > j) {
                    T[i][j] = T[i - 1][j];
                } else {
                    T[i][j] = T[i - 1][j] + T[i][j - coins[i - 1]];
                }
            }
        }

        return T[n][amount];
    }

    public int count(int[] S, int N)
    {
        int[] T = new int[N+1];
        T[0] = 1;

        for (int k : S) {
            for (int j = k; j <= N; j++) {
                T[j] += T[j - k];
            }
        }

        return T[N];
    }

}
