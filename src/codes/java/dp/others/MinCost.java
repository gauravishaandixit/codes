package codes.java.dp.others;

public class MinCost {

    int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] T = new int[m][n];
        T[0][0] = grid[0][0];

        for(int i = 1; i < m; i++)
            T[0][i] = T[0][i - 1] + grid[0][i];

        for(int j = 1; j < n; j++)
            T[j][0] = T[j - 1][0] + grid[j][0];

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                T[i][j] = Math.min(T[i - 1][j], T[i][j - 1]) + grid[i][j];
            }
        }

        return T[m - 1][n - 1];
    }

}
