package codes.java.dp.lis;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CountLIS {
    int countLIS(int[] arr)
    {
        int n = arr.length;

        int[] lis = new int[n];
        int[] count = new int[n];
        Arrays.fill(lis,1);
        Arrays.fill(count,1);

        int max = 1;

        for(int i = 1; i < n; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(arr[i] > arr[j])
                {
                    if(lis[i] == lis[j] + 1)
                        count[i] += count[j];
                    else
                        if(lis[i] < lis[j + 1])
                        {
                            lis[i] = lis[j] + 1;
                            count[i] = count[j];
                        }
                }
            }
            max = Math.max(max, lis[i]);
        }

        int ans = 0;

        for(int i = 0; i < n; i++)
        {
            if(lis[i] == max)
                ans += count[i];
        }
        return ans;
    }
}
