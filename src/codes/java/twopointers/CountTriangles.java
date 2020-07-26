package codes.java.twopointers;

import java.util.Arrays;

public class CountTriangles {
    long countTriangles(int arr[])
    {
        int n = arr.length;
        long ans = 0;
        Arrays.sort(arr);
        for(int i = n - 1; i >= 0; i--)
        {
            int j = 0, k = i - 1;

            while(j < k)
            {
                if(arr[j] + arr[k] > arr[i])
                {
                    ans += k - j;
                    k--;
                }
                else
                    j++;
            }
        }
        return ans;
    }
}
