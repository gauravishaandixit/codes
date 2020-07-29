package codes.java.binarysearch;

import java.util.Arrays;

//Given an array which consists of non-negative integers and an integer m,
// you can split the array into m non-empty continuous subarrays.
// Write an algorithm to minimize the largest sum among these m subarrays.
public class SplitArrayLargestSum {

    int splitArray(int[] nums, int m) {
        int minSum = Arrays.stream(nums).max().getAsInt();
        int maxSum = Arrays.stream(nums).sum();

        int ans = minSum;

        while(minSum <= maxSum)
        {
            int mid = minSum + (maxSum - minSum) / 2;
            int k = noOfSubarrays(nums, mid);
            if(k <= m)
            {
                ans = mid;
                maxSum = mid - 1;
            }
            else
                minSum = mid + 1;
        }
        return ans;
    }

    int noOfSubarrays(int[] nums, int maxSum)
    {
        int countOfSubarrays = 1;
        int totalSum = 0;

        for(int num : nums)
        {
            totalSum += num;
            if(totalSum > maxSum)
            {
                countOfSubarrays++;
                totalSum = num;
            }
        }
        return countOfSubarrays;
    }

}
