package codes.java.arrays;

import java.util.ArrayList;

public class RemoveAnElement {
    int removeElement(ArrayList<Integer> a, int b) {

        int n  = a.size();
        int i = 0;
        for(int j = 0; j < n; j++)
        {
            if(a.get(j) != b )
                a.set(i++, a.get(j));
        }
        return i;

    }
}
