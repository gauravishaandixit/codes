package codes.java.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

//Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
// find all unique combinations in candidates where the candidate numbers sums to target.
//
//The same repeated number may be chosen from candidates unlimited number of times.


public class CombinationSum {

    ArrayList<ArrayList<Integer>> ans;
    public ArrayList<ArrayList<Integer>> combinationSum(int[] nums, int target) {
        ans = new ArrayList<>();
        Arrays.sort(nums);

        doBackTrack(nums, new ArrayList<>(), 0, target);
        return ans;
    }
    void doBackTrack(int[] nums, ArrayList<Integer> arr, int start, int remain)
    {
        if(remain < 0)
            return;

        if(remain == 0)
        {
            ans.add(new ArrayList<>(arr));
            return;
        }

        for(int i = start; i < nums.length; i++)
        {
            arr.add(nums[i]);
            doBackTrack(nums, arr, i, remain - nums[i]); //not i + 1 because can reuse same element
            arr.remove(arr.size() - 1);
        }
    }

}
