package codes.java.arrays;

import java.util.ArrayList;

public class RemoveDuplicates2 {
    int removeDuplicates(ArrayList<Integer> a) {
        int n = a.size();
        int j = 0;

        for(int i = 0; i < n; i++)
        {
            if(i < n - 2 && a.get(i).equals(a.get(i + 1)) && a.get(i).equals(a.get(i + 2)))
                continue;
            else
            {
                a.set(j++, a.get(i));
            }
        }
        return j;
    }
}
