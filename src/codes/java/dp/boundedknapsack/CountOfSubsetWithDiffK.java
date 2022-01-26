package codes.java.dp.boundedknapsack;

import java.util.Arrays;

public class CountOfSubsetWithDiffK {
    //S1 - S2 = K
    //S1 + S2 = totalSum;
    //S1 = (K + totalSum) / 2;
    // (K + totalSum) is odd return 0 else same as count of subset sum;

    int countSubsetWithDiffK(int[] arr, int K) {
        int totalSum = Arrays.stream(arr).sum();

        if ((totalSum + K) % 2 != 0)
            return 0;

        int sum = (totalSum + K) / 2;
        return countOfSubsetSum(arr, sum);
    }


    int countOfSubsetSum(int[] arr, int S) {
        int n = arr.length;
        int[][] T = new int[n + 1][S + 1];
        for (int i = 0; i <= n; i++)
            T[i][0] = 1;

        for (int j = 1; j <= S; j++)
            T[0][j] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= S; j++) {
                T[i][j] = T[i - 1][j];
                if (arr[i - 1] <= j)
                    T[i][j] += T[i - 1][j - arr[i - 1]];
            }
        }

        return T[n][S];
    }

    public static void main(String[] args) {
        int[] set = new int[]{1, 2, 4, 6, 7};
        int K = 8;
        System.out.println(new CountOfSubsetWithDiffK().countSubsetWithDiffK(set, K));

        K = 4;
        System.out.println(new CountOfSubsetWithDiffK().countSubsetWithDiffK(set, K));

        K = 5;
        System.out.println(new CountOfSubsetWithDiffK().countSubsetWithDiffK(set, K));
    }
}
