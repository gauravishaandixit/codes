package codes.java.arrays;

// https://leetcode.com/problems/remove-element/

public class RemoveElement {

    int removeElement(int[] nums, int val)
    {
        int i = 0;
        for(int j = 0; j < nums.length; j++)
        {
            if(nums[j] != val)
            {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }


}
