package codes.java.dp.others;

import java.util.Arrays;

public class LongestIncreasingPathInMatrix {

    public int longestPath(int[][] matrix)
    {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        for(int[] arr : memo)
            Arrays.fill(arr, -1);
        int ans = 1;

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                ans = Math.max(ans, dfs(matrix, i, j, memo));
            }
        }
        return ans;
    }


    int dfs(int[][] matrix, int i, int j, int[][] memo)
    {
        if(memo[i][j] != 0)
            return memo[i][j];

        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int currMax = 1;

        for(int[] dir : dirs)
        {
            int x = i + dir[0], y = j + dir[1];

            if(isValidPosition(matrix, x, y) && matrix[x][y] > matrix[i][j])
                currMax = Math.max(currMax, 1 + dfs(matrix, x, y, memo));
        }
        return memo[i][j] = currMax;
    }

    boolean isValidPosition(int[][] matrix, int x, int y)
    {
        return x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length;
    }
}
