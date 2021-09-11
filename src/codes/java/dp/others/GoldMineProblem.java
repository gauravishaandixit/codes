package codes.java.dp.others;


// https://practice.geeksforgeeks.org/problems/gold-mine-problem2608/1

public class GoldMineProblem {

    int maxGold(int[][] mine) {
        int row = mine.length;
        int col = mine[0].length;

        int[][] T = new int[row][col];

        for(int i = col - 1; i >= 0; i--) {
            for(int j = 0; j < row; j++) {
                int right = i == col - 1 ? 0 : mine[j][i + 1];
                int rightUp = j == 0 || i == col - 1 ? 0 : mine[j - 1][i + 1];
                int rightDown = j == row - 1 ||  i == col - 1 ? 0 : mine[j + 1][i + 1];

                T[j][i] = Math.max(right, Math.max(rightUp, rightDown));
            }
        }

        int ans = T[0][0];
        for(int i = 1; i < row; i++)
            ans = Math.max(ans, T[i][0]);

        return ans;
    }

}
