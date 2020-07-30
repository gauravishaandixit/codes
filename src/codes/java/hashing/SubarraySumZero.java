package codes.java.hashing;

import java.util.HashMap;

public class SubarraySumZero {
    int[] longestSubarraySumZero(int[] arr)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int currSum = 0;
        int start = 0, end = 0;
        map.put(0, -1);
        for(int i = 0; i < arr.length; i++)
        {
            currSum += arr[i];
            if(map.containsKey(currSum))
            {
                if(i - map.get(currSum) > end - start)
                {
                    start = map.get(currSum);
                    end = i;
                }
            }
            else
                map.put(currSum, i);
        }
        return new int[]{start + 1, end };
    }

    public static void main(String[] ar)
    {
        int ans[] = new SubarraySumZero().longestSubarraySumZero(new int[]{1 ,2 ,-2 ,4 ,-4});
        System.out.println(ans[0] + " " + ans[1]);
    }
}
