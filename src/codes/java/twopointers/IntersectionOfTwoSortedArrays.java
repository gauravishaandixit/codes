package codes.java.twopointers;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoSortedArrays {
    ArrayList<Integer> intersection(final List<Integer> A, final List<Integer> B) {

        ArrayList<Integer> arr = new ArrayList<>();
        int i = 0 , j = 0;
        while(i < A.size() && j < B.size())
        {
            if(A.get(i).equals(B.get(j)))
            {
                arr.add(A.get(i));
                i++;
                j++;
            }
            else
            {
                if((int)A.get(i) > B.get(j))
                    j++;
                else
                    i++;
            }
        }
        return arr;
    }
}
