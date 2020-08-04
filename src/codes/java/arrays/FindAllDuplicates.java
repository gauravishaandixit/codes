package codes.java.arrays;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicates {

    List<Integer> findDuplicates(int[] nums)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = nums.length;

        for(int i = 0; i < n; i++)
        {
            int index = Math.abs(nums[i]);
            index--;

            if(nums[index] > 0)
                nums[index] *= -1;
            else
                ans.add(index + 1);
        }
        return ans;
    }

}
