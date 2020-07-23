package codes.java.dp.matrixcm;

import java.util.Arrays;

public class BurstBalloon {

    int maxCoins(int coins[])
    {
        int n = coins.length;
        int coinsNew[] = new int[n + 2];

        Arrays.fill(coinsNew, 1);
        int index = 1;
        for(int coin: coins)
            coinsNew[index++] = coin;
        n = coinsNew.length;
        int memo[][] = new int[n][n];

        for(int i = 0; i < n; i++)
            Arrays.fill(memo[i], -1);

        return maxCoinsHelper(coinsNew, 0, n - 2, memo);
    }

    int maxCoinsHelper(int[] arr, int i, int j, int[][] memo)
    {
        if(i >= j)
            return 0;

        if(memo[i][j] != -1)
            return memo[i][j];

        int currAns = Integer.MIN_VALUE;
        for(int k = i; k < j; k++)
        {
            int val = maxCoinsHelper(arr, i, k, memo) + maxCoinsHelper(arr, k + 1, j, memo)
                    + arr[i] * arr[k + 1] * arr[j + 1];

            currAns = Math.max(currAns, val);
        }

        return memo[i][j] = currAns;
    }

    public static void main(String[] args)
    {
        System.out.println(new BurstBalloon().maxCoins(new int[]{3,1,5,8}));
        System.out.println(new BurstBalloon().maxCoins(new int[]{1, 5}));
        System.out.println(new BurstBalloon().maxCoins(new int[]{3,1,5}));
        System.out.println(new BurstBalloon().maxCoins(new int[]{}));
        System.out.println(new BurstBalloon().maxCoins(new int[]{9}));
    }

}
