package codes.java.dp.matrixcm;

public class EggDropBottomUp {

    //Time Complexity:: n^2logn
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];
        for(int i = 0; i <= k; i++) {
            dp[i][1] = 1;
            dp[i][0] = 0;
        }

        for(int i = 1; i <= n; i++)
            dp[1][i] = i;

        for(int i = 2; i <= k; i++) {
            for(int j = 2; j <= n; j++) {
                int min = Integer.MAX_VALUE;
                // search for k in [1, j] to minimize number of moves
                int l = 1;
                int r = j;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    int a = dp[i - 1][mid - 1]; // break
                    int b = dp[i][j - mid]; // did not break
                    min = Math.min(min, Math.max(dp[i - 1][mid - 1], dp[i][j - mid]) + 1);
                    if (a == b)
                        break;
                    else
                    if(a < b)
                        l = mid + 1;
                    else
                        r = mid - 1;
                }
                dp[i][j] = min;
            }
        }
        return dp[k][n];
    }

    //Time Complexity:: n^3
    public int superEggDropTLE(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];
        int res = 0;
        for(int i = 0; i <= k; i++)
        {
            dp[i][1] = 1;
            dp[i][0] = 0;
        }

        for(int i = 1; i <= n; i++)
            dp[1][i] = i;

        for(int i = 2; i <= k; i++)
        {
            for(int j = 2; j <= n; j++)
            {
                dp[i][j] = Integer.MAX_VALUE;
                for(int x = 1; x <= j; x++)
                {
                    res = 1 + Math.max(dp[i - 1][x - 1] , dp[i][j - x]);

                    dp[i][j] = Math.min(dp[i][j], res);
                }
            }
        }

        return dp[k][n];
    }

    public static void main(String[] args)
    {
        System.out.println(new EggDropBottomUp().superEggDrop(1, 5));
        System.out.println(new EggDropBottomUp().superEggDrop(2, 5));
        System.out.println(new EggDropBottomUp().superEggDrop(6, 5));
        System.out.println(new EggDropBottomUp().superEggDrop(10000, 965));


        System.out.println(new EggDropBottomUp().superEggDropTLE(1, 5));
        System.out.println(new EggDropBottomUp().superEggDropTLE(2, 5));
        System.out.println(new EggDropBottomUp().superEggDropTLE(6, 5));
        System.out.println(new EggDropBottomUp().superEggDropTLE(10000, 965));
    }
}
