package codes.java.dp.string;

import java.util.Arrays;

public class MinCutPalindromePartitioning {
    int minCutPalindrome(String str)
    {
        int n = str.length();
        int T[][] = new int[n][n];
        boolean[][] isPal = new boolean[n][n];

        for(int[] dp: T)
            Arrays.fill(dp, n);

        for(int length = 1; length <= n; length++)
        {
            for(int left = 0; left < n - length + 1; left++)
            {
                int right = left + length - 1;
                if(str.charAt(left) == str.charAt(right))
                {
                    if(length == 1 || length == 2)
                        isPal[left][right] = true;
                    else
                        isPal[left][right] = isPal[left + 1][right -1 ];
                }

                if(isPal[left][right])
                {
                    T[left][right] = 0;
                    continue;
                }

                for(int p = left; p < right; p++)
                {
                    T[left][right] = Math.min(T[left][right], T[left][p] + T[p + 1][right] + 1);
                }
            }
        }
        return T[0][n-1];
    }

    public static void main(String[] ar)
    {
        System.out.println(new MinCutPalindromePartitioning().minCutPalindrome("aab"));
        System.out.println(new MinCutPalindromePartitioning().minCutPalindrome("aabaa"));
        System.out.println(new MinCutPalindromePartitioning().minCutPalindrome("abcde"));
    }
}
