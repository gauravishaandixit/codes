package codes.java.dp.others;

public class MaximalSquare {
    public int maximalSquare(char[][] mat) {
        int n = mat.length;
        if (n == 0)
            return 0;
        int m = mat[0].length;
        int[][] dp = new int[n][m];
        int area = 0;

        for (int i = 0; i < n; i++) {
            dp[i][0] = mat[i][0] - '0';
            area = Math.max(area, dp[i][0]);
        }

        for (int i = 0; i < m; i++) {
            dp[0][i] = mat[0][i] - '0';
            area = Math.max(area, dp[0][i]);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][j] == '1') {
                    dp[i][j] = 1 + (Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])));
                    area = Math.max(area, dp[i][j] * dp[i][j]);
                } else
                    dp[i][j] = 0;
            }
        }
        return area;
    }
}
