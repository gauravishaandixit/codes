package codes.java.dp.matrixcm;

import java.util.Arrays;

public class MinValueOfExpression {
    int calcMinValue(String exp)
    {
        int n = exp.length();
        int memo[][] = new int[n][n];
        for(int m[] : memo)
            Arrays.fill(m, -1);
        return helper(exp, 0, n - 1, memo);
    }

    int helper(String exp, int i, int j, int[][] memo)
    {
        if(i > j)
            return 0;
        if(i == j)
            return exp.charAt(i) - '0';

        if(memo[i][j] != -1)
            return memo[i][j];

        int ans = Integer.MAX_VALUE;

        for(int k = i + 1; k < j; k += 2)
        {
            int left = helper(exp, i , k - 1, memo);
            int right = helper(exp, k + 1, j, memo);
            int val = 0;
            if(exp.charAt(k) == '+')
                val = left + right;
            else
                val = left * right;

            ans = Math.min(ans, val);
        }
        return memo[i][j] = ans;
    }

    public static void main(String[] a)
    {
        System.out.println(new MinValueOfExpression().calcMinValue(("1+2*3")));
        System.out.println(new MinValueOfExpression().calcMinValue("1+2*3+4*5"));
        System.out.println(new MinValueOfExpression().calcMinValue("2*3+4+5*6"));
        System.out.println(new MinValueOfExpression().calcMinValue("1+2"));
        System.out.println(new MinValueOfExpression().calcMinValue("4*5+1"));
        System.out.println(new MinValueOfExpression().calcMinValue("2*2+4"));
    }
}
