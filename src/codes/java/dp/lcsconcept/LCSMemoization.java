package codes.java.dp.lcsconcept;

import java.util.Arrays;
//Top Down
public class LCSMemoization {

    int lcsMemo(String s1, String s2, int m, int n, int memo[][])
    {
        if(m == 0 || n == 0)
            return 0;

        if(memo[m][n] != -1)
            return memo[m][n];

        if(s1.charAt(m-1) == s2.charAt(n-1))
            return memo[m][n] = 1 + lcsMemo(s1, s2, m - 1, n - 1, memo);

        else
            return memo[m][n] = Math.max(lcsMemo(s1, s2, m, n - 1, memo), lcsMemo(s1, s2, m - 1, n, memo));
    }


    public static void main(String[] args)
    {
        String s1 = "abcgdef";
        int m = s1.length();
        String s2 = "afbgcfef";
        int n = s2.length();

        int memo[][] = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++)
            Arrays.fill(memo[i], -1);
        new LCSMemoization().lcsMemo(s1, s2, m, n, memo);
        System.out.println(memo[m][n]);
    }

}
