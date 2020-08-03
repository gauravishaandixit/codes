package codes.java.arrays;

public class RemoveDuplicates {

    int removeDuplicates(int[] nums) {

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

}
