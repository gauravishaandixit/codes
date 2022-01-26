package codes.java.dp.lcsconcept;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LossCalc {

    int loss(String s1, String s2, int cost1, int cost2) {
        int m = s1.length();
        int n = s2.length();

        int[][] t = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    t[i][j] = 1 + t[i - 1][j - 1];
                else
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
            }
        }
        int lcs = t[m][n];
        return (m - lcs) * cost1 + (n - lcs) * cost2;
    }

    public static void main(String[] strings) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s1 = st.nextToken();
        String s2 = st.nextToken();

        st = new StringTokenizer(br.readLine());

        int cost1 = Integer.parseInt(st.nextToken());
        int cost2 = Integer.parseInt(st.nextToken());

        System.out.println("Loss:: " + new LossCalc().loss(s1, s2, cost1, cost2));

    }
}
