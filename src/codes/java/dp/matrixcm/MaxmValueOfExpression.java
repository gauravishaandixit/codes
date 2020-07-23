package codes.java.dp.matrixcm;

import java.util.Arrays;

public class MaxmValueOfExpression {

    int calcMaxmValue(String exp)
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

        int ans = Integer.MIN_VALUE;

        for(int k = i + 1; k < j; k += 2)
        {
            int left = helper(exp, i , k - 1, memo);
            int right = helper(exp, k + 1, j, memo);
            int val = 0;
            if(exp.charAt(k) == '+')
                val = left + right;
            else
                val = left * right;

            ans = Math.max(ans, val);
        }
        return memo[i][j] = ans;
    }

    public static void main(String[] a)
    {
        System.out.println(new MaxmValueOfExpression().calcMaxmValue("1+2*3"));
        System.out.println(new MaxmValueOfExpression().calcMaxmValue("1+2*3+4*5"));
        System.out.println(new MaxmValueOfExpression().calcMaxmValue("2*3+4+5*6"));
        System.out.println(new MaxmValueOfExpression().calcMaxmValue("1+2"));
        System.out.println(new MaxmValueOfExpression().calcMaxmValue("4*5"));
        System.out.println(new MaxmValueOfExpression().calcMaxmValue("2*2+4"));
    }
}
