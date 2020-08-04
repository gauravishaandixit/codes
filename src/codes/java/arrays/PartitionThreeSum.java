package codes.java.arrays;

import java.util.Arrays;

public class PartitionThreeSum {

    int partitionThreeSum(int[] nums, int n)
    {
        int sum1 = 0, sum2, sum3;
        int count = 0;
        int total = Arrays.stream(nums).sum();

        for(int i = 0; i < n; i++)
        {
            sum1 += nums[i];
            sum2 = 0;

            for(int j = i + 1; j < n - 1; j++)
            {
                sum2 += nums[j];
                sum3 = total - (sum1 + sum2);

                if(sum1 == sum2 && sum1 == sum3)
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        System.out.println(new PartitionThreeSum().partitionThreeSum(new int[]{1, 2, 3, 0, 3}, 5));
        System.out.println(new PartitionThreeSum().partitionThreeSum(new int[]{0, 1, -1, 0}, 4));
    }
}
