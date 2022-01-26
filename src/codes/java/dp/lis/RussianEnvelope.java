package codes.java.dp.lis;

import java.util.Arrays;
import java.util.Comparator;

public class RussianEnvelope {

    int russianEnvelope(int[][] envelopes) {
        Arrays.sort(envelopes, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(envelopes, Comparator.comparingInt(a -> a[1]));

        int n = envelopes.length;
        int[] T = new int[n];
        Arrays.fill(T, 1);
        int ans = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if ((envelopes[i][0] > envelopes[j][0] && envelopes[i][0] > envelopes[j][0]) && T[i] < T[j] + 1)
                    T[i] = T[j] + 1;
            }
            ans = Math.max(ans, T[i]);
        }
        return ans;
    }
}
