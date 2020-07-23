package codes.java.dp.matrixcm;

import java.util.Arrays;

public class MCMTopDown {

    int mcmTopDown(int arr[])
    {
        int n = arr.length;
        int memo[][] = new int[n][n];

        for(int i = 0; i < n; i++)
            Arrays.fill(memo[i], -1);
        return mcmTopDownHelper(arr, 0, n - 2, memo);
    }

    int mcmTopDownHelper(int arr[], int i, int j, int[][] memo)
    {
        if(i >= j)
            return 0;

        if(memo[i][j] != -1)
            return memo[i][j];
        int ans = Integer.MAX_VALUE;

        for(int k = i; k < j; k++)
        {
            int val = mcmTopDownHelper(arr, i, k, memo) + mcmTopDownHelper(arr, k + 1, j, memo)
                    + (arr[i] * arr[k + 1] * arr[j + 1]);
            ans = Math.min(ans, val);
        }
        return memo[i][j] = ans;
    }

    public static void main(String[] args)
    {
        System.out.println(new MCMTopDown().mcmTopDown(new int[]{1,2,3,4,3}));
        System.out.println(new MCMTopDown().mcmTopDown(new int[]{40, 20, 30, 10, 30}));
        System.out.println(new MCMTopDown().mcmTopDown(new int[]{10, 20, 30, 40, 30}));
        System.out.println(new MCMTopDown().mcmTopDown(new int[]{10, 20}));
        System.out.println(new MCMTopDown().mcmTopDown(new int[]{10, 20, 30}));
    }
}
