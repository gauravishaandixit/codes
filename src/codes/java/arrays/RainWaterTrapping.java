package codes.java.arrays;

public class RainWaterTrapping {

    int rainWaterTrapped(int[] heights)
    {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = heights[0];
        for(int i = 1; i < n; i++)
            left[i] = Math.max(left[i-1], heights[i]);

        right[n - 1] = heights[n - 1];
        for(int i = n - 2; i >= 0; i--)
            right[i - 1] = Math.max(right[i + 1], heights[i]);

        int totalWater = 0;
        for(int i = 0; i < n; i++)
            totalWater += (Math.min(left[i], right[i]) - heights[i]);

        return totalWater;
    }

}
