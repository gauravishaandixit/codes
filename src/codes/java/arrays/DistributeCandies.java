package codes.java.arrays;

import java.util.Arrays;

public class DistributeCandies {

    int minNumOfCandies(int[] nums)
    {
        int n = nums.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        for(int i = 1; i < n; i++)
        {
            if(nums[i] > nums[i - 1])
                candies[i] = candies[i - 1] + 1;
        }

        for(int i = n - 2; i >= 0; i--)
        {
            if(nums[i] > nums[ i + 1])
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
        }
        return Arrays.stream(candies).sum();
    }

}
