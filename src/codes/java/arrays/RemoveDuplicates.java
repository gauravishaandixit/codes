package codes.java.arrays;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array

public class RemoveDuplicates {

    int removeDuplicates(int[] nums)
    {
        int i = 1, j = 1, n = nums.length;
        while(i < nums.length)
        {
            while(i < n && nums[i] == nums[i-1])
                i++;
            if(i == n)
                break;
            nums[j++] = nums[i++];
        }
        return j;
    }

    int removeDuplicatesDifferent(int[] nums) {
        int i = 0;
        for(int n : nums)
            if(i < 1 || n > nums[i - 1])
                nums[i++] = n;
        return i;
    }

}
