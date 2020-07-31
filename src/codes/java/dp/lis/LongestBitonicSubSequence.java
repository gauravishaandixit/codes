package codes.java.dp.lis;

import java.util.Arrays;

public class LongestBitonicSubSequence {
    int longestBitonicSubsequenceLength(int[] nums)
    {
        if(nums.length == 0)
            return 0;

        int n = nums.length;
        int lis[] = new int[n]; //Longest Increasing Subsequence
        int lds[] = new int[n]; //Longest Decreasing Subsequence

        Arrays.fill(lis, 1);
        Arrays.fill(lds, 1);

        //LIS
        for(int i = 1; i < n; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(nums[i] > nums[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;
            }
        }

        //LDS
        for(int i = n - 2; i >= 0; i--)
        {
            for(int j = n - 1; j> i; j--)
            {
                if(nums[i] > nums[j] && lds[i] < lds[j] + 1)
                    lds[i] = lds[j] + 1;
            }
        }

        int ans = 0;
        for(int i = 0; i < n; i++)
            ans = Math.max(ans, lis[i] + lds[i] );

        return ans - 1;// array element is counted twice
    }
}
