package codes.java.arrays;


import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/k-diff-pairs-in-an-array/
public class K_DIff_Pairs {

    int countPairs_1(int[] nums, int k)
    {
        if(k < 0)
            return 0;

        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums)
            map.put(num, map.getOrDefault(num, 0)+ 1);

        int result = 0;
        for(int num: map.keySet())
        {
            if(k == 0)
            {
                if(map.get(num) >= 2)
                    result++;
            }
            else
            {
                if(map.containsKey(num + k))
                    result++;
            }
        }
        return result;
    }

    // one pass
    int countPairs_2(int[] nums, int k)
    {
        if(k < 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;

        for(int num: nums)
        {
            if(map.containsKey(num))
            {
                if(k == 0 && map.get(num) == 1)
                    result++;

                map.put(num, map.get(num) + 1);
            }
            else
            {
                if(map.containsKey(num - k))
                    result++;

                if(map.containsKey(num + k))
                    result++;

                map.put(num, 1);
            }
        }
        return result;
    }

}
