package codes.java.arrays;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

public class RemoveDuplicates2 {
    int removeDuplicates(int[] nums) {
        int i = 0;
        for(int num: nums)
        {
            if(i < 2 || num > nums[i - 2])
                nums[i++] = num;

        }

        return i;
    }


    int removeDuplicatesWithAtmostK(int[] nums, int K)
    {
        int i = 0;
        for(int num: nums)
        {
            if(i < K || num > nums[i- K])
                nums[i++] = num;
        }
        return i;
    }
}
