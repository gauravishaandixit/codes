package codes.java.dp.lis;

import java.util.Arrays;

public class LIS {

    int lis(int[] arr)
    {
        int n = arr.length;
        int[] T = new int[n];
        Arrays.fill(T, 1);
        int ans = 1;
        for(int i = 1; i < n; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(arr[i] > arr[j] && T[i] < T[j] + 1)
                    T[i] = T[j] + 1;
            }
            ans = Math.max(ans, T[i]);
        }
        return ans;
    }
}
