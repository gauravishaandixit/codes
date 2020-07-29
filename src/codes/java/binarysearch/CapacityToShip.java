package codes.java.binarysearch;

import java.util.Arrays;

//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

public class CapacityToShip {
    int shipWithinDays(int[] weights, int D) {
        int min = Arrays.stream(weights).min().getAsInt();
        int max = Arrays.stream(weights).sum();

        int ans = max;

        while(min <= max)
        {
            int mid = min + (max - min) / 2;
            if(isPossible(weights, D, mid))
            {
                ans = mid;
                max = mid - 1;
            }
            else
                min = mid + 1;
        }

        return ans;
    }
    boolean isPossible(int[] weights, int D, int maxWeight)
    {
        int noOfDays = 1;
        int totalWeight = 0;

        for(int weight : weights)
        {
            totalWeight += weight;
            if(totalWeight > maxWeight)
            {
                totalWeight = weight;
                noOfDays++;
            }
            if(noOfDays > D)
                return false;
        }
        return true;
    }
}
