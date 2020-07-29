package codes.java.backtracking;

import java.util.ArrayList;

public class Permutations {

    ArrayList<ArrayList<Integer>> allPermutations(int[] arr)
    {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        findAll(arr, new ArrayList<>(), ans);
        return ans;
    }

    void findAll(int arr[], ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> ans)
    {
        //System.out.println(curr);
        if(curr.size() == arr.length)
        {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0; i < arr.length; i++)
        {
            if(curr.contains(arr[i])) continue;
            curr.add(arr[i]);
            findAll(arr, curr, ans);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args)
    {
        System.out.println(new Permutations().allPermutations(new int[]{1,2,3}));
        System.out.println(new Permutations().allPermutations(new int[]{2,3,4}));
        System.out.println(new Permutations().allPermutations(new int[]{5, 8, 3, 4}));
    }
}
