package codes.java.arrays;

public class MissingAndRepeating {

    int[] repeatedAndMissing(int[] nums)
    {
        int len = nums.length;
        int repeat = -1;
        int missing = -1;

        for(int i = 0; i < len; i++)
        {
            int x = Math.abs(nums[i]);

            if(nums[x-1] > 0)
                nums[x-1] = -nums[x-1];
            else
                repeat = x;
        }

        for(int i = 0; i < len; i++)
        {
            if(nums[i] > 0)
            {
                missing = i + 1;
                break;
            }
        }
        return new int[]{repeat, missing};
    }
}
