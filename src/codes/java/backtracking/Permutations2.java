package codes.java.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutations2 {
    ArrayList<ArrayList<Integer>> allPermutations(int[] arr)
    {
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        findAll(arr, new ArrayList<>(), new boolean[arr.length], ans);
        return ans;
    }

    void findAll(int[] arr, ArrayList<Integer> curr, boolean[] used, ArrayList<ArrayList<Integer>> ans)
    {
        if(curr.size() == arr.length)
        {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i < arr.length; i++)
        {
            if(used[i]) continue;
            if(i > 0 && arr[i] == arr[i -  1] && !used[i - 1]) continue;
            used[i] = true;
            curr.add(arr[i]);
            findAll(arr, curr, used, ans);
            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args)
    {
        System.out.println(new Permutations2().allPermutations(new int[]{1,1,2}));
        System.out.println(new Permutations2().allPermutations(new int[]{2,3,4,3}));
    }
}
