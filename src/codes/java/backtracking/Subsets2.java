package codes.java.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subsets2 {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> nums)
    {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Collections.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(ArrayList<ArrayList<Integer>> list, List<Integer> tempList, ArrayList<Integer> nums, int start){

        list.add(new ArrayList<>(tempList));

        for(int i = start; i < nums.size(); i++)
        {
            if(i > start && nums.get(i) == nums.get(i-1))
                continue; // skip duplicates

            tempList.add(nums.get(i));

            backtrack(list, tempList, nums, i + 1);

            tempList.remove(tempList.size() - 1);
        }
    }
}
