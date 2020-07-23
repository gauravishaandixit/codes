package codes.java.dp.matrixcm;

import java.util.Arrays;

public class EggDropMemo {
    int minNoWays(int eggs, int floors)
    {
        int memo[][] = new int[eggs + 1][floors + 1];
        for(int memos[] : memo)
            Arrays.fill(memos, -1);

        return minNoWays(eggs, floors, memo);
    }
    int minNoWays(int eggs, int floors, int[][] memo)
    {
        if(floors <= 1 || eggs == 1)
            return floors;

        if(memo[eggs][floors] != -1)
            return memo[eggs][floors];

        int ans = Integer.MAX_VALUE;

        for(int k = 1; k <= floors; k++)
        {
            int curr = 1 + Math.max(minNoWays(eggs - 1, k - 1, memo), minNoWays(eggs, floors - k, memo));
            ans = Math.min(curr, ans);
        }
        return memo[eggs][floors] = ans;
    }

    int minNoWays2(int eggs, int floors)
    {
        int memo[][] = new int[eggs + 1][floors + 1];
        for(int memos[] : memo)
            Arrays.fill(memos, -1);

        return minNoWays2(eggs, floors, memo);
    }

    int minNoWays2(int eggs, int floors, int[][] memo)
    {
        if(floors <= 1 || eggs == 1)
            return floors;

        if(memo[eggs][floors] != -1)
            return memo[eggs][floors];

        int ans = Integer.MAX_VALUE;

        for(int k = 1; k <= floors; k++)
        {
            int low = 0, right = 0;
            if(memo[eggs - 1][k -1] != -1)
                low = memo[eggs - 1][k -1];
            else
            {
                low = minNoWays2(eggs - 1, k - 1, memo);
                memo[eggs - 1][k -1] = low;
            }


            if(memo[eggs][floors - k] != -1)
                right = memo[eggs][floors - k];
            else
            {
                right = minNoWays2(eggs, floors - k, memo);
                memo[eggs][floors - k] = right;
            }

            int curr = 1 + Math.max(low, right);
            ans = Math.min(curr, ans);
        }
        return memo[eggs][floors] = ans;
    }


    public static void main(String[] args)
    {
        System.out.println(new EggDropMemo().minNoWays(1, 5));
        System.out.println(new EggDropMemo().minNoWays2(1, 5));

        System.out.println(new EggDropMemo().minNoWays(2, 5));
        System.out.println(new EggDropMemo().minNoWays2(2, 5));

        System.out.println(new EggDropMemo().minNoWays(6, 5));
        System.out.println(new EggDropMemo().minNoWays2(6, 5));

        System.out.println(new EggDropMemo().minNoWays(10000, 965));
        System.out.println(new EggDropMemo().minNoWays2(10000, 965));
    }
}
