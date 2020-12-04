package codes.java.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Subsets {
    ArrayList<ArrayList<Integer>> ans  = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A)
    {
        Collections.sort(A);
        ArrayList<Integer> arr = new ArrayList<>();
        findSubsets(A, arr, 0);

        Collections.sort(ans, (o1, o2) -> {
            int i = 0;
            while (i < o1.size() && i < o2.size())
            {
                if (o1.get(i) == o2.get(i))
                    i++;
                else
                    return o1.get(i).compareTo(o2.get(i));
            }

            return o1.size() > o2.size() ? 1 : -1;
        });

        return ans;
    }
    void findSubsets(ArrayList<Integer> A, ArrayList<Integer> arr, int index )
    {
        if(index == A.size())
        {
            ans.add(new ArrayList<>(arr));
            return;
        }
        findSubsets(A, arr, index + 1);
        arr.add(A.get(index));
        findSubsets(A, arr, index + 1);
        arr.remove(arr.size() - 1);

    }
    public static void main(String[] arg)
    {
        System.out.println(new Subsets().subsets(new ArrayList<>(Arrays.asList(1,2,3))));
    }
}
