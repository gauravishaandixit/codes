package codes.java.dp.lis;

import java.util.Arrays;

public class LongestIncreasingOddEvenSubsequence {
    int longestIncreasingOddEven(int[] arr)
    {
        int n = arr.length;
        int[] T = new int[n];
        Arrays.fill(T, 1);

        int ans = 1;
        for(int i = 1; i < n; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(arr[j] < arr[i] && (arr[i] + arr[j] % 2 != 0) && (T[i] < T[j] + 1))
                    T[i] = T[j] + 1;
            }

            ans = Math.max(ans, T[i]);
        }
        return ans;
    }

    public static void main(String[] args)
    {
        int[] arr = new int[]{ 1, 12, 2, 22,
                5, 30, 31, 14, 17, 11 };
        System.out.println(new LongestIncreasingOddEvenSubsequence().longestIncreasingOddEven(arr));
    }
}
