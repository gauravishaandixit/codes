package codes.java.twopointers;

import java.util.ArrayList;

public class ContainerWithMostWater {
    int maxWater(ArrayList<Integer> A) {

        int i = 0;
        int j = A.size()-1;

        int ans = 0;
        while(i < j)
        {
            ans = Math.max(ans, Math.min(A.get(i), A.get(j)) * (j - i));

            if(A.get(i) < A.get(j))
                i++;
            else
                j--;
        }
        return ans;
    }
}
