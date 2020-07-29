package codes.java.backtracking;

// Given a collection of candidate numbers (candidates) and a target number (target),
// find all unique combinations in candidates where the candidate numbers sums to target.
//
//Each number in candidates may only be used once in the combination.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    List<List<Integer>> ans;

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        ans = new ArrayList<>();
        Arrays.sort(nums);

        doBacktrack(nums, new ArrayList<>(), target, 0);
        return ans;
    }

    void doBacktrack(int[] nums, ArrayList<Integer> arr, int remain, int start)
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
            if(i > start && nums[i] == nums[i-1]) continue;
            arr.add(nums[i]);
            doBacktrack(nums, arr, remain - nums[i], i + 1);
            arr.remove(arr.size() - 1);
        }
    }
}