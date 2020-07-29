package codes.java.backtracking;

import java.util.ArrayList;

public class Combination {

    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> combine(int n, int k) {

        findCombinations(new ArrayList<Integer>(), 1, n, k);

        return ans;
    }

    void findCombinations(ArrayList<Integer> arr, int curr, int n, int k)
    {
        if(k == 0)
        {
            ans.add(new ArrayList<>(arr));
            return;
        }

        for(int i = curr; i <= n-k+1; i++)
        {
            arr.add(i);
            findCombinations(arr, i+1, n, k-1);
            arr.remove(arr.size()-1);
        }
    }
}
