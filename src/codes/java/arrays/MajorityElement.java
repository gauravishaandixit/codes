package codes.java.arrays;

public class MajorityElement {

    int majorityElement(int[] nums)
    {
        int cand = 0;
        int count = 0;
        int i = 0;
        while(i < nums.length)
        {
            if(count == 0)
            {
                cand = nums[i];
            }

            if(nums[i] == cand)
                count++;
            else
                count --;

            i++;
        }
        return cand;
    }
}
