package codes.java.dp.boundedknapsack;

import java.util.Arrays;

public class EqualSumPartition {
    boolean equalPartition(int[] arr)
    {
        int totalSum = Arrays.stream(arr).sum();
        if((totalSum & 1) == 1)
            return false;

        int sum = totalSum >> 1;
        int n = arr.length;

        boolean[][] T = new boolean[n + 1][sum + 1];
        for(int i = 0; i <= n; i++)
            T[i][0] = true;

        for(int j = 1; j <= sum; j++)
            T[0][j] = false;

        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j<= sum; j++)
            {
                T[i][j] = T[i-1][j];
                if(arr[i-1] <= j)
                    T[i][j] |= T[i-1][j - arr[i-1]];
            }
        }

        return T[n][sum];
    }

    public static void main(String[] args)
    {
        int[] set = new int[]{1, 2, 4, 5, 7};
        System.out.println(new EqualSumPartition().equalPartition(set));
        set = new int[]{1, 5, 5, 11};
        System.out.println(new EqualSumPartition().equalPartition(set));

        set = new int[]{1, 5, 5, 7};
        System.out.println(new EqualSumPartition().equalPartition(set));
    }
}
