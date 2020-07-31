package codes.java.dp.others;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticProgression {

    int longestAP(int[] nums)
    {
        int n = nums.length;
        if(n <= 2)
            return n;

        HashMap<Integer, Integer>[] T = new HashMap[n];
        int ans = 0;

        for(int i = 0; i < n; i++)
        {
            T[i] = new HashMap<>();
            for(int j = 0; j < i; j++)
            {
                int d = nums[i] - nums[j];
                T[i].put(d, T[j].getOrDefault(d, 1) + 1);
                ans = Math.max(ans, T[i].get(d));
            }
        }
        return ans;
    }

    public static void main(String[] args)
    {
        System.out.println(new LongestArithmeticProgression().longestAP(new int[]{3, 6, 9, 12}));
        System.out.println(new LongestArithmeticProgression().longestAP(new int[]{9, 4, 7, 2, 10}));
    }

}
