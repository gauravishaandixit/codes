package codes.java.arrays;


// relative posn of non zero must be same
public class MoveZeroesToEnd {

    void moveZeroes(int[] nums)
    {
        int pos=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] != 0)
            {
                nums[pos] = nums[i];
                pos++;
            }
        }
        for(;pos<nums.length;pos++)
            nums[pos] = 0;
    }

}
