package codes.java.dp.others;

import java.util.Arrays;

public class EditDistance {

    int editDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] T = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0) {
                    T[i][j] = j;
                } else {
                    if(j == 0) {
                        T[i][j] = i;
                    } else {
                        T[i][j] = Math.min(T[i][j - 1], Math.min(T[i - 1][j], T[i - 1][j - 1])) + 1;
                    }
                }
            }
        }

        return T[m - 1][n - 1];
    }

}
