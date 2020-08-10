package codes.java.dp.lis;

import java.util.Arrays;
import java.util.Comparator;

public class ChainOfPairs {

    int longestChainOfPairs(int[][] pairs)
    {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
        int[] T = new int[pairs.length];
        Arrays.fill(T, 1);
        int ans = 1;

        for(int i = 1; i < pairs.length; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(pairs[j][1] < pairs[i][0])
                    T[i] = Math.max(T[i], T[j] + 1);
            }
            ans = Math.max(ans, T[i]);
        }
        return ans;
    }
}
