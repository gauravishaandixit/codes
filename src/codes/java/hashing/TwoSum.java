package codes.java.hashing;

import java.util.HashMap;

// https://www.interviewbit.com/problems/2-sum/

public class TwoSum {

    int[] twoSum(int[] A, int B) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < A.length; i++)
        {
            if(map.containsKey(B - A[i]))
                return new int[]{map.get(B - A[i]) + 1, i + 1};

            else
            if(!map.containsKey(A[i]))
                map.put(A[i], i);
        }
        return new int[0];
    }

}
