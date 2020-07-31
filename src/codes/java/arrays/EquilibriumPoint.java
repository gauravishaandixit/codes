package codes.java.arrays;

import java.util.Arrays;

public class EquilibriumPoint {

    int equilibriumPoint(int[] nums)
    {
        int sum = Arrays.stream(nums).sum();
        int leftSum = 0;

        for(int i = 0; i < nums.length; i++)
        {
            sum -= nums[i];

            if(leftSum == sum)
                return i;

            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] ar)
    {
        System.out.println(new EquilibriumPoint().equilibriumPoint(new int[]{-7, 1, 5, 2, -4, 3, 0}));
    }
}
