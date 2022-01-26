package codes.java.dp.lis;

public class MaxmSumIncrSubsequence {
    int msis(int[] arr)
    {
        int n = arr.length;
        int[] msis = new int[n];

        System.arraycopy(arr, 0, msis, 0, n);

        int ans = 0;

        for(int i = 1;i < n; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(arr[j] < arr[i] && msis[i] < msis[j] + arr[i])
                    msis[i] = msis[j] + arr[i];
            }

            ans = Math.max(ans, msis[i]);
        }
        return ans;
    }
}
