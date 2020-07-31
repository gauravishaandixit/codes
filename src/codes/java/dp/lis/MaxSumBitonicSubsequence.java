package codes.java.dp.lis;

import java.util.stream.IntStream;

public class MaxSumBitonicSubsequence {
    int maxmSumBitonic(int[] arr)
    {
        int n = arr.length;
        int ans = 0;

        int[] msis = new int[n];
        int[] msds = new int[n];


        IntStream.range(0, n).forEach(i -> msis[i] = arr[i]);
        IntStream.range(0, n).forEach(i -> msds[i] = arr[i]);

        for(int i = 1; i < n; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(arr[i] > arr[j] && msis[i] < msis[j] + arr[i])
                    msis[i] = msis[j] + arr[i];
            }
        }

        for(int i = n - 2;i >= 0; i--)
        {
            for(int j = n - 1; j > i; j--)
            {
                if(arr[i] > arr[j] && msds[i] < msds[j] + arr[i])
                    msds[i] = msds[j] + arr[i];
            }
        }

        for(int i = 0; i < n; i++)
            ans = Math.max(ans, msis[i] + msds[i] - arr[i]);

        return ans;
    }

    public static void main(String[] args)
    {
        System.out.println(new MaxSumBitonicSubsequence().maxmSumBitonic(new int[]{80, 60, 30, 40, 20, 10}));
        System.out.println(new MaxSumBitonicSubsequence().maxmSumBitonic(new int[]{1, 15, 51, 45, 33, 100, 12, 18, 9}));
    }
}
